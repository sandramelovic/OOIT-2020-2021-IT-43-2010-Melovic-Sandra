package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtR;
	private JTextField txtInnerR;
	public boolean isOk;
	public Donut donut;
	public JButton btnInnerColor;
	public JButton btnOutlineColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Add or modify donut");
		setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Center coordinate X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 5;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			JLabel lblY = new JLabel("Center coordinate Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.gridwidth = 2;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 10;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 5;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 5);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 10;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblR = new JLabel("Radius:");
			GridBagConstraints gbc_lblR = new GridBagConstraints();
			gbc_lblR.insets = new Insets(0, 0, 5, 5);
			gbc_lblR.gridx = 5;
			gbc_lblR.gridy = 4;
			contentPanel.add(lblR, gbc_lblR);
		}
		{
			JLabel lblInnerR = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblInnerR = new GridBagConstraints();
			gbc_lblInnerR.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerR.gridx = 10;
			gbc_lblInnerR.gridy = 4;
			contentPanel.add(lblInnerR, gbc_lblInnerR);
		}
		{
			txtR = new JTextField();
			GridBagConstraints gbc_txtR = new GridBagConstraints();
			gbc_txtR.insets = new Insets(0, 0, 5, 5);
			gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtR.gridx = 5;
			gbc_txtR.gridy = 5;
			contentPanel.add(txtR, gbc_txtR);
			txtR.setColumns(10);
		}
		{
			txtInnerR = new JTextField();
			GridBagConstraints gbc_txtInnerR = new GridBagConstraints();
			gbc_txtInnerR.insets = new Insets(0, 0, 5, 5);
			gbc_txtInnerR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerR.gridx = 10;
			gbc_txtInnerR.gridy = 5;
			contentPanel.add(txtInnerR, gbc_txtInnerR);
			txtInnerR.setColumns(10);
		}
		
				btnOutlineColor = new JButton("Outline Color");
				btnOutlineColor.setForeground(Color.PINK);
				btnOutlineColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
								btnOutlineColor.getBackground());
						if (outlineColor != null)
							btnOutlineColor.setBackground(outlineColor);

					}
				});
						
						btnInnerColor = new JButton("Inner Color");
						btnInnerColor.setForeground(Color.PINK);
						btnInnerColor.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
								if (innerColor != null)
									btnInnerColor.setBackground(innerColor);

							}
						});
						btnInnerColor.setBackground(Color.BLACK);
						GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
						gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
						gbc_btnInnerColor.gridx = 3;
						gbc_btnInnerColor.gridy = 7;
						contentPanel.add(btnInnerColor, gbc_btnInnerColor);
				
						btnOutlineColor.setBackground(Color.BLACK);
						GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
						gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
						gbc_btnOutlineColor.gridx = 3;
						gbc_btnOutlineColor.gridy = 8;
						contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtR.getText().trim().isEmpty() || txtInnerR.getText().trim().isEmpty()) {
							setConfirm(false);
							JOptionPane.showMessageDialog(null, "All values are required!", "Error",
									JOptionPane.ERROR_MESSAGE);

						} else {
							try {
								if (Integer.parseInt(txtInnerR.getText().toString()) <= 0
										|| Integer.parseInt(txtR.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0)
									JOptionPane.showMessageDialog(null, "Insert values greater then 0!", "Error",
											JOptionPane.ERROR_MESSAGE);
								else {
									if (Integer.parseInt(txtInnerR.getText().toString()) < Integer
											.parseInt(txtR.getText().toString())) {
										donut = new Donut(
												new Point(Integer.parseInt(txtX.getText().toString()),
														Integer.parseInt(txtY.getText().toString())),
												Integer.parseInt(txtR.getText().toString()),
												Integer.parseInt(txtInnerR.getText().toString()), false,
												btnOutlineColor.getBackground(), btnInnerColor.getBackground());

										setConfirm(true);
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(null,
												"Please insert inner radius less than outher radius!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}

								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public JTextField getTxtInnerR() {
		return txtInnerR;
	}

	public void setTxtInnerR(JTextField txtInnerR) {
		this.txtInnerR = txtInnerR;
	}

	public boolean isConfirm() {
		return isOk;
	}

	public void setConfirm(boolean isOk) {
		this.isOk = isOk;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}


}
