package skyWars;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Toolkit;

public class SkyWarsGUI extends JFrame implements Observer {
	
	//declare local variables
	private SkyWars game = new SkyWars();

	private JPanel contentPane;
	
	private JLabel lblbackground;
	
	private JPanel pnlGrid;
	private JLabel lblEmpty;
	private JLabel lblX1;
	private JLabel lblX2;
	private JLabel lblX3;
	private JLabel lblX4;
	private JLabel lblY1;
	private JLabel lblR1S1;
	private JLabel lblR1S2;
	private JLabel lblR1S3;
	private JLabel lblR1S4;
	private JLabel lblY2;
	private JLabel lblR2S1;
	private JLabel lblR2S2;
	private JLabel lblR2S3;
	private JLabel lblR2S4;
	private JLabel lblY3;
	private JLabel lblR3S1;
	private JLabel lblR3S2;
	private JLabel lblR3S3;
	private JLabel lblR3S4;
	private JLabel lblY4;
	private JLabel lblR4S1;
	private JLabel lblR4S2;
	private JLabel lblR4S3;
	private JLabel lblR4S4;
	
	private JPanel pnlInfoPane;
	private JLabel lblMasterShip;
	private JLabel lblBattleCruiser;
	private JLabel lblBattleShooter;
	private JLabel lblBattleStar;
	private JLabel lblGameInfo;
	
	private JPanel pnlButtonLayout;
	private JButton btnStartButton;
	private JButton btnModeButton;
	private JButton btnMoveButton;
	private JButton btnSaveButton;
	private JButton btnLoadButton;
	
	private ImageIcon background = scaleBackground(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\imgBackground.jpg"));
	private ImageIcon masterShip = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconMasterShip.png"));
	private ImageIcon battleCruiser = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconBattleCruiser.png"));
	private ImageIcon battleShooter = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconBattleShooter.png"));
	private ImageIcon battleStar = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconBattleStar.png"));
	private ImageIcon wormHole = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconWormHole.png"));
	private ImageIcon enemies = scaleIcon(new ImageIcon("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconEnemies.png"));
	
	private File saveFile = new File("..\\files\\SaveFile.txt");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkyWarsGUI frame = new SkyWarsGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SkyWarsGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Users\\Joan\\Documents\\Eclipse Workspace SD2\\CW\\src\\images\\iconMasterShip.png"));
		setResizable(false);
		setTitle("Sky Wars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnlGrid());
		contentPane.add(getPnlButtonLayout());	
		contentPane.add(getPnlInfoPane());
		contentPane.add(getLblbackground());
	}
	//background label
	private JLabel getLblbackground() {
		if (lblbackground == null) {
			lblbackground = new JLabel(background);
			lblbackground.setBounds(5, 5, 1280, 720);
		}
		return lblbackground;
	}
	//end of background components
	
	//grid components
	private JPanel getPnlGrid() {
		if (pnlGrid == null) {
			pnlGrid = new JPanel();
			pnlGrid.setBounds(144, 50, 600, 450);
			pnlGrid.setLayout(new GridLayout(5, 5, 0, 0));
			pnlGrid.setBackground(new Color(0,0,0,0));
			pnlGrid.add(getLblEmpty());
			pnlGrid.add(getLblX1());
			pnlGrid.add(getLblX2());
			pnlGrid.add(getLblX3());
			pnlGrid.add(getLblX4());
			pnlGrid.add(getLblY1());
			pnlGrid.add(getLblR1S1());
			pnlGrid.add(getLblR1S2());
			pnlGrid.add(getLblR1S3());
			pnlGrid.add(getLblR1S4());
			pnlGrid.add(getLblY2());
			pnlGrid.add(getLblR2S1());
			pnlGrid.add(getLblR2S2());
			pnlGrid.add(getLblR2S3());
			pnlGrid.add(getLblR2S4());
			pnlGrid.add(getLblY3());
			pnlGrid.add(getLblR3S1());
			pnlGrid.add(getLblR3S2());
			pnlGrid.add(getLblR3S3());
			pnlGrid.add(getLblR3S4());
			pnlGrid.add(getLblY4());
			pnlGrid.add(getLblR4S1());
			pnlGrid.add(getLblR4S2());
			pnlGrid.add(getLblR4S3());
			pnlGrid.add(getLblR4S4());
		}
		return pnlGrid;
	}
	private JLabel getLblEmpty() {
		if (lblEmpty == null) {
			lblEmpty = new JLabel("", SwingConstants.CENTER);
			lblEmpty.setForeground(new Color(102, 180, 244));
			lblEmpty.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblEmpty;
	}
	private JLabel getLblX1() {
		if (lblX1 == null) {
			lblX1 = new JLabel("X1", SwingConstants.CENTER);
			lblX1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblX1.setForeground(new Color(102, 180, 244));
			lblX1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblX1;
	}
	private JLabel getLblX2() {
		if (lblX2 == null) {
			lblX2 = new JLabel("X2", SwingConstants.CENTER);
			lblX2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblX2.setForeground(new Color(102, 180, 244));
			lblX2.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblX2;
	}
	private JLabel getLblX3() {
		if (lblX3 == null) {
			lblX3 = new JLabel("X3", SwingConstants.CENTER);
			lblX3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblX3.setForeground(new Color(102, 180, 244));
			lblX3.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblX3;
	}
	private JLabel getLblX4() {
		if (lblX4 == null) {
			lblX4 = new JLabel("X4", SwingConstants.CENTER);
			lblX4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblX4.setForeground(new Color(102, 180, 244));
			lblX4.setBorder(new MatteBorder(0, 1, 1, 2, (Color) new Color(102, 180, 244)));
		}
		return lblX4;
	}
	private JLabel getLblY1() {
		if (lblY1 == null) {
			lblY1 = new JLabel("Y1", SwingConstants.CENTER);
			lblY1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblY1.setForeground(new Color(102, 180, 244));
			lblY1.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblY1;
	}
	private JLabel getLblR1S1() {
		if (lblR1S1 == null) {
			lblR1S1 = new JLabel("", SwingConstants.CENTER);
			lblR1S1.setBackground(new Color(1, 23, 73));
			lblR1S1.setOpaque(true);
			lblR1S1.setForeground(new Color(102, 180, 244));
			//lblR1S1.setIcon(scaleIcon(wormHole));
			lblR1S1.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR1S1;
	}
	private JLabel getLblR1S2() {
		if (lblR1S2 == null) {
			lblR1S2 = new JLabel("", SwingConstants.CENTER);
			lblR1S2.setBackground(new Color(1, 23, 73));
			lblR1S2.setOpaque(true);
			lblR1S2.setForeground(new Color(102, 180, 244));
			lblR1S2.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR1S2;
	}
	private JLabel getLblR1S3() {
		if (lblR1S3 == null) {
			lblR1S3 = new JLabel("", SwingConstants.CENTER);
			lblR1S3.setBackground(new Color(1, 23, 73));
			lblR1S3.setOpaque(true);
			lblR1S3.setForeground(new Color(102, 180, 244));
			lblR1S3.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR1S3;
	}
	private JLabel getLblR1S4() {
		if (lblR1S4 == null) {
			lblR1S4 = new JLabel("", SwingConstants.CENTER);
			lblR1S4.setBackground(new Color(1, 23, 73));
			lblR1S4.setOpaque(true);
			lblR1S4.setForeground(new Color(102, 180, 244));
			lblR1S4.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(102, 180, 244)));
		}
		return lblR1S4;
	}
	private JLabel getLblY2() {
		if (lblY2 == null) {
			lblY2 = new JLabel("Y2", SwingConstants.CENTER);
			lblY2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblY2.setForeground(new Color(102, 180, 244));
			lblY2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblY2;
	}
	private JLabel getLblR2S1() {
		if (lblR2S1 == null) {
			lblR2S1 = new JLabel("", SwingConstants.CENTER);
			lblR2S1.setBackground(new Color(1, 23, 73));
			lblR2S1.setOpaque(true);
			lblR2S1.setForeground(new Color(102, 180, 244));
			lblR2S1.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR2S1;
	}
	private JLabel getLblR2S2() {
		if (lblR2S2 == null) {
			lblR2S2 = new JLabel("", SwingConstants.CENTER);
			lblR2S2.setBackground(new Color(1, 23, 73));
			lblR2S2.setOpaque(true);
			lblR2S2.setForeground(new Color(102, 180, 244));
			lblR2S2.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR2S2;
	}
	private JLabel getLblR2S3() {
		if (lblR2S3 == null) {
			lblR2S3 = new JLabel("", SwingConstants.CENTER);
			lblR2S3.setBackground(new Color(1, 23, 73));
			lblR2S3.setOpaque(true);
			lblR2S3.setForeground(new Color(102, 180, 244));
			lblR2S3.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR2S3;
	}
	private JLabel getLblR2S4() {
		if (lblR2S4 == null) {
			lblR2S4 = new JLabel("", SwingConstants.CENTER);
			lblR2S4.setBackground(new Color(1, 23, 73));
			lblR2S4.setOpaque(true);
			lblR2S4.setForeground(new Color(102, 180, 244));
			lblR2S4.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(102, 180, 244)));
		}
		return lblR2S4;
	}
	private JLabel getLblY3() {
		if (lblY3 == null) {
			lblY3 = new JLabel("Y3", SwingConstants.CENTER);
			lblY3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblY3.setForeground(new Color(102, 180, 244));
			lblY3.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(102, 180, 244)));
		}
		return lblY3;
	}	
	private JLabel getLblR3S1() {
		if (lblR3S1 == null) {
			lblR3S1 = new JLabel("", SwingConstants.CENTER);
			lblR3S1.setBackground(new Color(1, 23, 73));
			lblR3S1.setOpaque(true);
			lblR3S1.setForeground(new Color(102, 180, 244));
			lblR3S1.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR3S1;
	}
	private JLabel getLblR3S2() {
		if (lblR3S2 == null) {
			lblR3S2 = new JLabel("", SwingConstants.CENTER);
			lblR3S2.setBackground(new Color(1, 23, 73));
			lblR3S2.setOpaque(true);
			lblR3S2.setForeground(new Color(102, 180, 244));
			lblR3S2.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR3S2;
	}
	private JLabel getLblR3S3() {
		if (lblR3S3 == null) {
			lblR3S3 = new JLabel("", SwingConstants.CENTER);
			lblR3S3.setBackground(new Color(1, 23, 73));
			lblR3S3.setOpaque(true);
			lblR3S3.setForeground(new Color(102, 180, 244));
			lblR3S3.setBorder(new LineBorder(new Color(102, 180, 244)));
		}
		return lblR3S3;
	}
	private JLabel getLblR3S4() {
		if (lblR3S4 == null) {
			lblR3S4 = new JLabel("", SwingConstants.CENTER);
			lblR3S4.setBackground(new Color(1, 23, 73));
			lblR3S4.setOpaque(true);
			lblR3S4.setForeground(new Color(102, 180, 244));
			lblR3S4.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(102, 180, 244)));
		}
		return lblR3S4;
	}
	private JLabel getLblY4() {
		if (lblY4 == null) {
			lblY4 = new JLabel("Y4", SwingConstants.CENTER);
			lblY4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblY4.setForeground(new Color(102, 180, 244));
			lblY4.setBorder(new MatteBorder(1, 0, 2, 1, (Color) new Color(102, 180, 244)));
		}
		return lblY4;
	}
	private JLabel getLblR4S1() {
		if (lblR4S1 == null) {
			lblR4S1 = new JLabel("", SwingConstants.CENTER);
			lblR4S1.setBackground(new Color(1, 23, 73));
			lblR4S1.setOpaque(true);
			lblR4S1.setForeground(new Color(102, 180, 244));
			lblR4S1.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(102, 180, 244)));
		}
		return lblR4S1;
	}
	private JLabel getLblR4S2() {
		if (lblR4S2 == null) {
			lblR4S2 = new JLabel("", SwingConstants.CENTER);
			lblR4S2.setBackground(new Color(1, 23, 73));
			lblR4S2.setOpaque(true);
			lblR4S2.setForeground(new Color(102, 180, 244));
			lblR4S2.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(102, 180, 244)));
		}
		return lblR4S2;
	}
	private JLabel getLblR4S3() {
		if (lblR4S3 == null) {
			lblR4S3 = new JLabel("", SwingConstants.CENTER);
			lblR4S3.setBackground(new Color(1, 23, 73));
			lblR4S3.setOpaque(true);
			lblR4S3.setForeground(new Color(102, 180, 244));
			lblR4S3.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(102, 180, 244)));
		}
		return lblR4S3;
	}
	private JLabel getLblR4S4() {
		if (lblR4S4 == null) {
			lblR4S4 = new JLabel("", SwingConstants.CENTER);
			lblR4S4.setBackground(new Color(1, 23, 73));
			lblR4S4.setOpaque(true);
			lblR4S4.setForeground(new Color(102, 180, 244));
			lblR4S4.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(102, 180, 244)));
		}
		return lblR4S4;
	}
	//end of grid panel components
	
	//info panel components
	private JPanel getPnlInfoPane() {
		if (pnlInfoPane == null) {
			pnlInfoPane = new JPanel();
			pnlInfoPane.setBackground(new Color(0, 0, 0, 0));
			pnlInfoPane.setBorder(new LineBorder(new Color(102, 180, 244), 2));
			pnlInfoPane.setBounds(863, 50, 300, 450);
			pnlInfoPane.setLayout(new GridLayout(5, 1, 0, 0));
			pnlInfoPane.add(getLblMasterShip());
			pnlInfoPane.add(getLblBattleCruiser());
			pnlInfoPane.add(getLblBattleShooter());
			pnlInfoPane.add(getLblBattleStar());
			pnlInfoPane.add(getLblGameInfo());
		}
		return pnlInfoPane;
	}
	private JLabel getLblMasterShip() {
		if (lblMasterShip == null) {
			lblMasterShip = new JLabel("Master Ship");
			lblMasterShip.setBackground(new Color(1, 23, 73));
			lblMasterShip.setOpaque(true);
			lblMasterShip.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMasterShip.setHorizontalAlignment(SwingConstants.LEFT);
			lblMasterShip.setForeground(new Color(102, 180, 244));
			lblMasterShip.setIcon(masterShip);
		}
		return lblMasterShip;
	}
	private JLabel getLblBattleCruiser() {
		if (lblBattleCruiser == null) {
			lblBattleCruiser = new JLabel("Battle Cruiser");
			lblBattleCruiser.setBackground(new Color(1, 23, 73));
			lblBattleCruiser.setOpaque(true);
			lblBattleCruiser.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBattleCruiser.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(102, 180, 244)));
			lblBattleCruiser.setForeground(new Color(102, 180, 244));
			lblBattleCruiser.setIcon(battleCruiser);
		}
		return lblBattleCruiser;
	}
	private JLabel getLblBattleShooter() {
		if (lblBattleShooter == null) {
			lblBattleShooter = new JLabel("Battle Shooter");
			lblBattleShooter.setBackground(new Color(1, 23, 73));
			lblBattleShooter.setOpaque(true);
			lblBattleShooter.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBattleShooter.setForeground(new Color(102, 180, 244));
			lblBattleShooter.setIcon(battleShooter);
		}
		return lblBattleShooter;
	}
	private JLabel getLblBattleStar() {
		if (lblBattleStar == null) {
			lblBattleStar = new JLabel("Battle Star");
			lblBattleStar.setBackground(new Color(1, 23, 73));
			lblBattleStar.setOpaque(true);
			lblBattleStar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBattleStar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102, 180, 244)));
			lblBattleStar.setForeground(new Color(102, 180, 244));
			lblBattleStar.setIcon(battleStar);
		}
		return lblBattleStar;
	}
	private JLabel getLblGameInfo() {
		if (lblGameInfo == null) {
			lblGameInfo = new JLabel("");
			lblGameInfo.setBackground(new Color(1, 23, 73));
			lblGameInfo.setOpaque(true);
			lblGameInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblGameInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameInfo.setForeground(new Color(102, 180, 244));
		}
		return lblGameInfo;
	}
	//end info panel components
	
	//button layout panel components
	private JPanel getPnlButtonLayout() {
		if (pnlButtonLayout == null) {
			pnlButtonLayout = new JPanel();
			pnlButtonLayout.setBorder(new LineBorder(new Color(102, 180, 244), 2));
			pnlButtonLayout.setBounds(396, 570, 515, 65);
			pnlButtonLayout.setLayout(null);
			pnlButtonLayout.setBackground(new Color(0,0,0,0));
			pnlButtonLayout.add(getBtnStartButton());
			pnlButtonLayout.add(getBtnModeButton());
			pnlButtonLayout.add(getBtnMoveButton());
			pnlButtonLayout.add(getBtnSaveButton());
			pnlButtonLayout.add(getBtnLoadButton());
		}
		return pnlButtonLayout;
	}
	private JButton getBtnStartButton() {
		if (btnStartButton == null) {
			btnStartButton = new JButton("Start Game");
			btnStartButton.setForeground(new Color(0, 48, 120));
			btnStartButton.setBackground(new Color(252, 92, 125));
			btnStartButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnStartButton.setBounds(5, 5, 120, 55);
			btnStartButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblGameInfo.setText("");
					game.initialise();
					updateMasterShipLabel();
					updateGridPanelLabels();
					
				}
			});
		}
		return btnStartButton;
	}
	private JButton getBtnModeButton() {
		if (btnModeButton == null) {
			btnModeButton = new JButton("Change Mode");
			btnModeButton.setForeground(new Color(0, 48, 120));
			btnModeButton.setBackground(new Color(170, 114, 196));
			btnModeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnModeButton.setBounds(130, 5, 130, 55);
			btnModeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.changeMode();
					updateMasterShipLabel();
				}
			});
		}
		return btnModeButton;
	}
	private JButton getBtnMoveButton() {
		if (btnMoveButton == null) {
			btnMoveButton = new JButton("Move");
			btnMoveButton.setBackground(new Color(102, 180, 244));
			btnMoveButton.setForeground(new Color(0, 48, 120));
			btnMoveButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnMoveButton.setBounds(265, 5, 120, 55);
			btnMoveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.move();
					updateGridPanelLabels();
					checkIfGameOver();
				}
			});
		}
		return btnMoveButton;
	}
	private JButton getBtnSaveButton() {
		if (btnSaveButton == null) {
			btnSaveButton = new JButton("Save Game");
			btnSaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					saveFile();
				}
			});
			btnSaveButton.setForeground(new Color(102, 180, 244));
			btnSaveButton.setBackground(new Color(0, 48, 120));
			btnSaveButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnSaveButton.setBounds(390, 5, 120, 25);
		}
		return btnSaveButton;
	}
	private JButton getBtnLoadButton() {
		if (btnLoadButton == null) {
			btnLoadButton = new JButton("Load Game");
			btnSaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loadFile();
				}
			});
			btnLoadButton.setForeground(new Color(102, 180, 244));
			btnLoadButton.setBackground(new Color(0, 48, 120));
			btnLoadButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnLoadButton.setBounds(390, 35, 120, 25);
		}
		return btnLoadButton;
	}
	//end of button layout panel components
	
	//Own methods
	//Scaling images to fit in JLabels
	public ImageIcon scaleBackground(ImageIcon imageIcon) {
		//declare local variables
		final int WIDTH = 1280;
		final int HEIGHT = 720;
		//sequence to scale the background
		Image canvas = imageIcon.getImage();
		Image sclBg = canvas.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		ImageIcon scaledbackground =  new ImageIcon(sclBg);
		return scaledbackground;
	}//end method that scales the background
	public ImageIcon scaleIcon(ImageIcon imageIcon) {
		//declare local variables
		final int PIXELS = 75;
		//sequence to scale icons
		Image canvas = imageIcon.getImage();
		Image sclBg = canvas.getScaledInstance(PIXELS, PIXELS, Image.SCALE_SMOOTH);
		ImageIcon scaledbackground =  new ImageIcon(sclBg);
		return scaledbackground;
	}//end method that scales the icons
		
	//method that updates all labels in the grid panel according to a square
	public void updateGridPanelLabels() {		
		updateLabel(getLblR1S1(), 1, 1);//update lblR1S1 according to Row 1 Square 1
		updateLabel(getLblR1S2(), 1, 2);//update lblR1S1 according to Row 1 Square 2
		updateLabel(getLblR1S3(), 1, 3);//update lblR1S1 according to Row 1 Square 3
		updateLabel(getLblR1S4(), 1, 4);//update lblR1S1 according to Row 1 Square 4
		updateLabel(getLblR2S1(), 2, 1);//update lblR1S1 according to Row 2 Square 1
		updateLabel(getLblR2S2(), 2, 2);//update lblR1S1 according to Row 2 Square 2
		updateLabel(getLblR2S3(), 2, 3);//update lblR1S1 according to Row 2 Square 3
		updateLabel(getLblR2S4(), 2, 4);//update lblR1S1 according to Row 2 Square 4
		updateLabel(getLblR3S1(), 3, 1);//update lblR1S1 according to Row 3 Square 1
		updateLabel(getLblR3S2(), 3, 2);//update lblR1S1 according to Row 3 Square 2
		updateLabel(getLblR3S3(), 3, 3);//update lblR1S1 according to Row 3 Square 3
		updateLabel(getLblR3S4(), 3, 4);//update lblR1S1 according to Row 3 Square 4
		updateLabel(getLblR4S1(), 4, 1);//update lblR1S1 according to Row 4 Square 1
		updateLabel(getLblR4S2(), 4, 2);//update lblR1S1 according to Row 4 Square 2
		updateLabel(getLblR4S3(), 4, 3);//update lblR1S1 according to Row 4 Square 3
		updateLabel(getLblR4S4(), 4, 4);//update lblR1S1 according to Row 4 Square 4
	}//end method that updates the grid labels based on the associated square's info
	
	//method that updates each label specifically
	public void updateLabel(JLabel label, int y, int x) {
		//declare local variables
		Square tempSquare = game.findCoordinates(x, y);
		final int ONE = 1;
		final int ZERO = 0;
		//Change the label according to the info in the square
		if (tempSquare.getNumberOfShips() > ONE) {//if multiple enemies...
			//...change the label to show icon for multiple enemies;
			label.setIcon(null);//first clear the label
			label.setIcon(enemies);
		} else if(tempSquare.getNumberOfShips() == ONE) {//else if only one enemy...
			//...change the label to show the icon depending of which ship is present
			//switch statement to check the name
			switch(tempSquare.getEnemyShips().get(ZERO).getName()) {
			case("BattleCruiser")://if name is BattleCruiser...
				label.setIcon(null);//first clear the label
				label.setIcon(battleCruiser);//...change the icon to battleCruiser
				break;
			case("BattleShooter")://if name is BattleShooter...
				label.setIcon(null);//...first clear the label, then...
				label.setIcon(battleShooter);//...change the icon to battleShooter
				break;
			case("BattleStar")://if name is BattleStar...
				label.setIcon(null);//...first clear the label, then...
				label.setIcon(battleStar);//...change the icon to battleStar
				break;
			}//end switch statement
		} else if(tempSquare.isMasterShipPresent()) {//else if masterShip is present...
			//...change the icon to show masterShip
			label.setIcon(null);//first clear the label
			label.setIcon(masterShip);
			//else if the square is number 1 square on row 1...
		} else if (tempSquare.getRowNumber() == ONE && tempSquare.getNumber() == ONE) {
			label.setIcon(null);//first clear the label
			label.setIcon(wormHole);//...change the icon to show the wormHole

		} else {//else change the icon label to be null
			label.setIcon(null);
		}//end else if statements
	}
	
	//method that updates master ship label
	public void updateMasterShipLabel() {
		//declare local variables
		final int DEFENSIVE = 1;
		final int OFFENSIVE = 2;
		final String DEFENSIVE_MODE = "Master Ship: Defensive Mode";
		final String OFFENSIVE_MODE = "Master Ship: Offensive Mode";
		//if statements based on ship mode strength
		if(game.getMasterShip().modeStrength() == DEFENSIVE) {
			lblMasterShip.setText("");//first set the text to empty
			lblMasterShip.setText(DEFENSIVE_MODE);
		}
		if(game.getMasterShip().modeStrength() == OFFENSIVE) {
			lblMasterShip.setText("");//first set the text to empty
			lblMasterShip.setText(OFFENSIVE_MODE);
		}//end if statements
	}//end method that updates label for MasterShip
	
	//method that checks if game is over
	public void checkIfGameOver() {
		//declare loval variables
		String END_TEXT = "GAME OVER - Start a New Game";
		if(game.isGameOver()) {
			//if the game is over update the label with the game info
			lblGameInfo.setText(END_TEXT);
			this.game = new SkyWars();
		}//end if statement
	}//end method that checks for game over
	
	//method to save file
	public void saveFile() {
		try{
			FileOutputStream out = new FileOutputStream(this.saveFile);
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			//save data
			objOut.writeObject(this.saveFile);
			objOut.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}//end method that saves the file
	
	//method that laods the file
	public void loadFile() {
		try {
			FileInputStream in = new FileInputStream(this.saveFile);
			ObjectInputStream objIn = new ObjectInputStream(in);

			this.game = (SkyWars) objIn.readObject();

			objIn.close();

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}  catch(IOException e) {
			e.printStackTrace();
		}
	}//end method that loads file
}//end GUI class
