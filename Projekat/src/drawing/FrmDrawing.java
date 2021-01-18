package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing(this);

	private JToggleButton tglbtnPoint = new JToggleButton("Point");
	private JToggleButton tglbtnLine = new JToggleButton("Line");
	private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglbtnCircle = new JToggleButton("Circle");
	private JToggleButton tglbtnDonut = new JToggleButton("Donut");

	private JToggleButton tglbtnSelect = new JToggleButton("Select");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {

		setTitle("Sandra Melovic IT43/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnlDrawing.setBackground(Color.WHITE);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.BLACK);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		tglbtnPoint.setBackground(Color.PINK);
		tglbtnPoint.setForeground(Color.BLACK);

		pnlNorth.add(tglbtnPoint);
		tglbtnLine.setBackground(Color.PINK);
		pnlNorth.add(tglbtnLine);
		tglbtnCircle.setBackground(Color.PINK);
		pnlNorth.add(tglbtnCircle);
		tglbtnDonut.setBackground(Color.PINK);
		pnlNorth.add(tglbtnDonut);
		tglbtnRectangle.setBackground(Color.PINK);
		pnlNorth.add(tglbtnRectangle);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(tglbtnPoint);
		btnGroup.add(tglbtnLine);
		btnGroup.add(tglbtnCircle);
		btnGroup.add(tglbtnDonut);
		btnGroup.add(tglbtnRectangle);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.BLACK);
		tglbtnSelect.setBackground(Color.PINK);
		pnlSouth.add(tglbtnSelect);

		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(Color.PINK);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (pnlDrawing.getSelectedShape() != null) {
					modify();
					pnlDrawing.getSelectedShape().setSelected(false);

				} else {
					JOptionPane.showMessageDialog(null, "Please, select what you want to modify!", "Error",
							JOptionPane.ERROR_MESSAGE);
					tglbtnSelect.setSelected(true);
				}
				pnlDrawing.setSelectedShape(null);
				tglbtnSelect.setSelected(false);

			}
		});
		pnlSouth.add(btnModify);
		btnGroup.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.PINK);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				tglbtnSelect.setSelected(false);
			}
		});
		pnlSouth.add(btnDelete);
		btnGroup.add(btnDelete);

		pnlDrawing.repaint();
	}

	protected void delete() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning message",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				pnlDrawing.getShapes().remove(selectedShape);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		pnlDrawing.setSelectedShape(null);
		pnlDrawing.repaint();
	}

	protected void modify() {

		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {

			if (selectedShape instanceof Point) {

				Point p = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();

				dialog.getTxtX().setText("" + Integer.toString(p.getX()));
				dialog.getTxtY().setText("" + Integer.toString(p.getY()));
				dialog.getBtnColor().setBackground(p.getColor());
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getP());
					repaint();
				}

			} else if (selectedShape instanceof Donut) {

				Donut donut = (Donut) selectedShape;
				DlgDonut dialogd = new DlgDonut();

				dialogd.getTxtX().setText("" + Integer.toString(donut.getCenter().getX()));
				dialogd.getTxtY().setText("" + Integer.toString(donut.getCenter().getY()));
				dialogd.getTxtR().setText("" + Integer.toString(donut.getR()));
				dialogd.getTxtInnerR().setText("" + Integer.toString(donut.getInnerR()));
				dialogd.getBtnInnerColor().setBackground(donut.getInnerColor());
				dialogd.getBtnOutlineColor().setBackground(donut.getColor());
				dialogd.setModal(true);
				dialogd.setVisible(true);

				if (dialogd.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialogd.getDonut());
					repaint();
				}
			} else if (selectedShape instanceof Circle && (selectedShape instanceof Donut) == false) {

				Circle circle = (Circle) selectedShape;
				DlgCircle dialog = new DlgCircle();

				dialog.getTxtX().setText("" + Integer.toString(circle.getCenter().getX()));
				dialog.getTxtY().setText("" + Integer.toString(circle.getCenter().getY()));
				dialog.getTxtR().setText("" + Integer.toString(circle.getR()));
				dialog.getBtnInnerColor().setBackground(circle.getInnerColor());
				dialog.getBtnOutlineColor().setBackground(circle.getColor());

				dialog.setVisible(true);
				dialog.setModal(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getCircle());
					repaint();
				}

			} else if (selectedShape instanceof Line) {

				Line line = (Line) selectedShape;
				DlgLine dialog = new DlgLine();

				dialog.getTxtStartPointX().setText("" + Integer.toString(line.getStartPoint().getX()));
				dialog.getTxtStartPointY().setText("" + Integer.toString(line.getStartPoint().getY()));
				dialog.getTxtEndPointX().setText("" + Integer.toString(line.getEndPoint().getX()));
				dialog.getTxtEndPointY().setText("" + Integer.toString(line.getEndPoint().getY()));
				dialog.getBtnOutlineColor().setBackground(line.getColor());

				dialog.setVisible(true);

				if (dialog.isConfirm()) {

					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getLine());
					repaint();
				}

			} else if (selectedShape instanceof Rectangle) {

				Rectangle rect = (Rectangle) selectedShape;
				DlgRectangle dialog = new DlgRectangle();

				dialog.getTxtUpperLeftX().setText("" + Integer.toString(rect.getUpperLeft().getX()));
				dialog.getTxtUpperLeftY().setText("" + Integer.toString(rect.getUpperLeft().getY()));
				dialog.getTxtHeight().setText("" + Integer.toString(rect.getHeight()));
				dialog.getTxtWidth().setText("" + Integer.toString(rect.getWidth()));
				dialog.getBtnInnerColor().setBackground(rect.getInnerColor());
				dialog.getBtnOutlineColor().setBackground(rect.getColor());
				dialog.setModal(true);
				dialog.setVisible(true);

				if (dialog.isConfirm()) {
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(dialog.getRect());
					repaint();
				}
			}

		}
	}

	public PnlDrawing getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

}