import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField GPR0BitField;
	private JButton GPR0Button;
	private JTextField GPR1BitField;
	private JButton GPR1Button;
	private JTextField GPR2BitField;
	private JButton GPR2Button;
	private JTextField GPR3BitField;
	private JButton GPR3Button;
	private JTextField IX1BitField;
	private JButton IX1Button;
	private JTextField IX2BitField;
	private JButton IX2Button;
	private JTextField IX3BitField;
	private JButton IX3Button;
	private JTextField IRBitField;
	private JButton IRButton;
	private JTextField PCBitField;
	private JButton PCButton;
	private JTextField MARBitField;
	private JButton MARButton;
	private JTextField MBRBitField;
	private JButton MBRButton;
	private JTextField textField_1;
	private JTextField MFRBitField;
	private JButton MFRButton;
	private JTextField CCBitField;
	private JButton CCButton;
	private JPanel panel;
	private JTextField MARMemory;
	private JButton IPLButton;

	private JPanel bitPanel;
	private	JPanel commandPanel;

	private String switchValue;
	private JToggleButton[] switches;
	private final Memory memory;

	private final int screenInc = 1280/10;
	private final int textFieldWidth = 150;
	private final int textFieldHeight = 23;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel bitPanel = new JPanel();
		bitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel labelBitPanel = new JPanel();
		
		commandPanel = new JPanel();
		commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(commandPanel, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(labelBitPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(bitPanel, GroupLayout.PREFERRED_SIZE, 1042, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(bitPanel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelBitPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(commandPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addGap(71))
		);
		panel.setLayout(null);

		this.memory = new Memory();

		this.addGeneralPurposeRegisters();
		this.addIndexRegisters();
		this.addIR();
		this.addPC();
		this.addMAR();
		this.addMBR();
		this.addMFR();
		this.addIPL();
		this.addCC();

		this.addStoreAndLoad();

		this.addSwitches(bitPanel);
		this.resetMachineState();

		JLabel opCodeLabel = new JLabel("Opcode");
		opCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opCodeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel IXLabel = new JLabel("IX");
		IXLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		IXLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel RLabel = new JLabel("R");
		RLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		RLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel ILabel = new JLabel("I");
		ILabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ILabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setAlignmentX(0.5f);

		GroupLayout gl_labelBitPanel = new GroupLayout(labelBitPanel);
		gl_labelBitPanel.setHorizontalGroup(
			gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_labelBitPanel.createSequentialGroup()
					.addGap(84)
					.addComponent(opCodeLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IXLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(RLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ILabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(333))
		);
		gl_labelBitPanel.setVerticalGroup(
			gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_labelBitPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_labelBitPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_labelBitPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(IXLabel)
							.addComponent(opCodeLabel))
						.addGroup(gl_labelBitPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(addressLabel)
							.addComponent(ILabel)
							.addComponent(RLabel)))
					.addGap(13))
		);
		labelBitPanel.setLayout(gl_labelBitPanel);
		contentPane.setLayout(gl_contentPane);
	}

	private void addCC() {
		JLabel CCLabel = new JLabel("CC");
		CCBitField = new JTextField(4);
		CCBitField.setEditable(false);
		CCButton = new JButton("Load");
		CCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		CCLabel.setBounds(   (int) (screenInc*4  ), 264, 48, textFieldHeight);
		this.CCButton.setBounds(  (int) (screenInc*4.5), 264, 62, textFieldHeight);
		this.CCBitField.setBounds((int) (screenInc*5  ), 265, textFieldWidth, textFieldHeight);
		panel.add(CCLabel);
		panel.add(this.CCButton);
		panel.add(this.CCBitField);
		
		JButton RUN = new JButton("RUN");
		RUN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//need to input instruction
                boolean run = true;
			    while(run) {
                    singleStep();
                    if(Integer.parseInt(PCBitField.getText(), 2) >= memory.memory.length) {
                        PCBitField.setText("0".repeat(PCBitField.getColumns()));
                        run = false;
                        refresh();
                    }
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
				
			}
		});
		RUN.setBounds(856, 79, 120, 72);
		panel.add(RUN);
	}

	private void resetMachineState() {
		this.GPR0BitField.setText("0".repeat(16));
		this.GPR1BitField.setText("0".repeat(16));
		this.GPR2BitField.setText("0".repeat(16));
		this.GPR3BitField.setText("0".repeat(16));
		this.IX1BitField.setText("0".repeat(16));
		this.IX2BitField.setText("0".repeat(16));
		this.IX3BitField.setText("0".repeat(16));
		this.PCBitField.setText("0".repeat(12));
		this.MARBitField.setText("0".repeat(12));
		//this.setRegisterValue(this.MARBitField, this.memory.getValue(this.MARBitField.getText()));
		this.MBRBitField.setText("0".repeat(16));
		this.IRBitField.setText("0".repeat(16));
		this.MFRBitField.setText("0".repeat(4));
		this.switchValue = "0".repeat(16);
		for (JToggleButton jToggleButton : this.switches) {
			jToggleButton.setSelected(false);
		}
	}

	private void addGeneralPurposeRegisters() {
		JLabel GPR0Label = new JLabel("GPR 0");

		this.GPR0BitField = new JTextField(16);
		this.GPR0BitField.setName("gpr0");
		this.GPR0BitField.setEditable(false);
		this.GPR0Button = new JButton("Load");
		GPR0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.GPR0BitField);
			}
		});

		GPR0Label.setBounds(   (int) (screenInc*1), 11, 48, textFieldHeight);
		GPR0Button.setBounds(  (int) (screenInc*1.5), 11, 62, textFieldHeight);
		GPR0BitField.setBounds((int) (screenInc*2), 11, textFieldWidth, textFieldHeight);
		panel.add(GPR0Label);
		panel.add(GPR0Button);
		panel.add(GPR0BitField);

		JLabel GPR1Label = new JLabel("GPR 1");
		this.GPR1BitField = new JTextField(16);
		this.GPR1BitField.setName("gpr1");
		this.GPR1BitField.setEditable(false);
		this.GPR1Button = new JButton("Load");
		GPR1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR1Label.setBounds(   (int) (screenInc*1  ), 45, 48, textFieldHeight);
		GPR1Button.setBounds(  (int) (screenInc*1.5), 45, 62, textFieldHeight);
		GPR1BitField.setBounds((int) (screenInc*2  ), 45, textFieldWidth, textFieldHeight);
		panel.add(GPR1Label);
		panel.add(GPR1Button);
		panel.add(GPR1BitField);

		JLabel GPR2Label = new JLabel("GPR2");
		this.GPR2BitField = new JTextField(16);
		this.GPR2BitField.setName("gpr2");
		this.GPR2BitField.setEditable(false);
		this.GPR2Button = new JButton("Load");
		GPR2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR2Label.setBounds(   (int) (screenInc*1  ), 79, 48, textFieldHeight);
		GPR2Button.setBounds(  (int) (screenInc*1.5), 79, 62, textFieldHeight);
		GPR2BitField.setBounds((int) (screenInc*2  ), 79, textFieldWidth, textFieldHeight);
		panel.add(GPR2Label);
		panel.add(GPR2Button);
		panel.add(GPR2BitField);


		JLabel GPR3Label = new JLabel("GPR3");
		this.GPR3BitField = new JTextField(16);
		this.GPR3BitField.setName("gpr3");
		this.GPR3BitField.setEditable(false);
		this.GPR3Button = new JButton("Load");
		JButton GPR3Button = new JButton("Load");
		GPR3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GPR3Label.setBounds(   (int) (screenInc*1  ), 113, 48, textFieldHeight);
		this.GPR3Button.setBounds(  (int) (screenInc*1.5), 113, 62, textFieldHeight);
		GPR3BitField.setBounds((int) (screenInc*2  ), 113, textFieldWidth, textFieldHeight);
		panel.add(GPR3Label);
		panel.add(this.GPR3Button);
		panel.add(this.GPR3BitField);

	}

	private void addIndexRegisters() {
		JLabel IX1Label = new JLabel("IX1");
		JButton X1Button = new JButton("Load");

		X1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		this.IX1BitField = new JTextField(16);
		this.IX1BitField.setName("ix1");
		this.IX1BitField.setEditable(false);
		this.IX1Button = new JButton("Load");
		IX1Label.setBounds(   (int) (screenInc*4  ), 11, 48, textFieldHeight);
		IX1Button.setBounds(  (int) (screenInc*4.5), 11, 62, textFieldHeight);
		IX1BitField.setBounds((int) (screenInc*5  ), 11, textFieldWidth, textFieldHeight);
		panel.add(IX1Label);
		panel.add(IX1Button);
		panel.add(IX1BitField);


		JLabel IX2Label = new JLabel("IX2");
		this.IX2BitField = new JTextField(16);
		this.IX2BitField.setName("ix2");
		this.IX2BitField.setEditable(false);
		this.IX2Button = new JButton("Load");

		IX2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IX2Label.setBounds(   (int) (screenInc*4  ), 45, 48, textFieldHeight);
		IX2Button.setBounds(  (int) (screenInc*4.5), 45, 62, textFieldHeight);
		IX2BitField.setBounds((int) (screenInc*5  ), 45, textFieldWidth, textFieldHeight);
		panel.add(IX2Label);
		panel.add(IX2Button);
		panel.add(IX2BitField);

		JLabel IX3Label = new JLabel("IX3");
		this.IX3BitField = new JTextField(16);
		this.IX3BitField.setName("ix3");
		this.IX3BitField.setEditable(false);
		this.IX3Button = new JButton("Load");

		IX3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IX3Label.setBounds(   (int) (screenInc*4  ), 79, 48, textFieldHeight);
		IX3Button.setBounds(  (int) (screenInc*4.5), 79, 62, textFieldHeight);
		IX3BitField.setBounds((int) (screenInc*5  ), 79, textFieldWidth, textFieldHeight);
		panel.add(IX3Label);
		panel.add(IX3Button);
		panel.add(IX3BitField);

	}

	private void addIR() {
		JLabel IRLabel = new JLabel("IR");
		this.IRBitField = new JTextField(16);
		this.IRBitField.setName("ir");
		this.IRBitField.setEditable(false);
		JButton IRButton = new JButton("Load");
		IRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		IRLabel.setBounds(   (int) (screenInc*1  ), 264, 48, textFieldHeight);
		IRButton.setBounds(  (int) (screenInc*1.5), 264, 62, textFieldHeight);
		IRBitField.setBounds((int) (screenInc*2  ), 264, textFieldWidth, textFieldHeight);
		panel.add(IRLabel);
		panel.add(IRButton);
		panel.add(IRBitField);
	}

	private void addPC() {
		JLabel PCLabel = new JLabel("PC");
		this.PCBitField = new JTextField(12);
		this.PCBitField.setName("pc");
		this.PCBitField.setEditable(false);
		this.PCButton = new JButton("Load");
		PCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PCLabel.setBounds(   (int) (screenInc*1  ), 162, 48, textFieldHeight);
		PCButton.setBounds(  (int) (screenInc*1.5), 162, 62, textFieldHeight);
		PCBitField.setBounds((int) (screenInc*2  ), 162, textFieldWidth, textFieldHeight);
		panel.add(PCLabel);
		panel.add(PCButton);
		panel.add(PCBitField);
	}

	private void addMAR() {
		JLabel MARLabel = new JLabel("MAR");
		this.MARBitField = new JTextField(12);
		this.MARBitField.setName("mar");
		this.MARBitField.setEditable(false);
		this.MARButton = new JButton("Load");
		JLabel MemoryAtMARLabel = new JLabel("Memory at MAR");

		this.MARMemory = new JTextField(16);
		MARMemory.setText("1010");
		this.MARMemory.setEditable(false);


		MARButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.MARBitField);

				
			}
		});

		MemoryAtMARLabel.setBounds((int) (screenInc*4), 197, 120, textFieldHeight);
		MARMemory.setBounds((int) (screenInc*5), 197, textFieldWidth, textFieldHeight);
		panel.add(MemoryAtMARLabel);
		panel.add(MARMemory);

		MARLabel.setBounds(   (int) (screenInc*1), 196, 48, textFieldHeight);
		MARButton.setBounds(  (int) (screenInc*1.5), 196, 62, textFieldHeight);
		MARBitField.setBounds((int) (screenInc*2), 196, textFieldWidth, textFieldHeight);
		panel.add(MARLabel);
		panel.add(MARButton);
		panel.add(MARBitField);
	}

	private void addMBR() {
		JLabel MBRLabel = new JLabel("MBR");
		this.MBRBitField = new JTextField(16);
		this.MBRBitField.setName("mbr");
		this.MBRBitField.setEditable(false);
		this.MBRButton = new JButton("Load");

		MBRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.MBRBitField);

			}
		});

		MBRLabel.setBounds((int) (screenInc*1), 230, 48, textFieldHeight);
		MBRButton.setBounds((int) (screenInc*1.5), 230, 62, textFieldHeight);
		MBRBitField.setBounds((int) (screenInc*2), 230, textFieldWidth, textFieldHeight);
		panel.add(MBRLabel);
		panel.add(MBRButton);
		panel.add(MBRBitField);
	}



	private void addMFR() {
		JLabel MFRLabel = new JLabel("MFR");
		this.MFRBitField = new JTextField(16);
		this.MFRBitField.setName("mfr");
		this.MFRBitField.setEditable(false);
		MFRLabel.setBounds((int) (screenInc*4), 230, 120, textFieldHeight);
		MFRBitField.setBounds((int) (screenInc*5), 230, textFieldWidth, textFieldHeight);
		panel.add(MFRLabel);
		panel.add(MFRBitField);
	}

	private void addIPL() {
		this.IPLButton = new JButton("IPL");
		this.IPLButton.setBounds(screenInc*2, 300, 120, textFieldHeight*2);

        this.IPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadBootProgram();
			}
		});
		panel.add(IPLButton);

	}

	private void addStoreAndLoad() {
		//Store Button
		JButton storeButton = new JButton("Store");
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Value=Integer.parseInt(MBRBitField.getText(),2);
				int Index=Integer.parseInt(MARBitField.getText(),2);
	            memory.insertX(Value, Index);

				//Put code here
			}
		});

		commandPanel.add(storeButton);

		//Load Button
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index_marmemory=Integer.parseInt(MARBitField.getText(),2);
				System.out.println(index_marmemory);
				
				
				 int n5 = memory.getValue(index_marmemory);
		            String string = Integer.toBinaryString(n5);
		            int n6 = MBRBitField.getText().length() - string.length();
		            String string2 = "0".repeat(n6) + string;
		            MBRBitField.setText(string2);
				
				
				
				
				

				memory.getValue(index_marmemory);
				//Put code here
			}
		});
		commandPanel.add(loadButton);
		JButton nextStepButton = new JButton("Next Step");
		nextStepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleStep();
			}
		});
		commandPanel.add(nextStepButton);
	}

    private void singleStep() {
        MARBitField.setText(PCBitField.getText());
        int data = memory.getValue(Integer.parseInt(PCBitField.getText(), 2));
        String binString = Integer.toBinaryString(data);
        binString = binString.length() == MBRBitField.getColumns() ? binString : "0".repeat(MBRBitField.getColumns()-binString.length()) + binString;
        MBRBitField.setText(binString);
        IRBitField.setText(MBRBitField.getText());
        CPU.instruction(IRBitField.getText());
        PCBitField.setText(Integer.toBinaryString(Integer.parseInt(PCBitField.getText(), 2)+1));
        refresh();
    }

    private void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }

	public void setRegisterValue(JTextField jTextField, int n) {
		if (jTextField.getText().length() <= 0) {
			System.out.println("Error setting register value: invalid length");
			return;
		}
		String string = Integer.toBinaryString(n);
		int n2 = jTextField.getText().length() - string.length();
		String string2 = "0".repeat(n2) + string;
		jTextField.setText(string2);
	}

	private void loadSwitchValue(JTextField jTextField) {
		if (this.switchValue.length() > jTextField.getText().length()) {
			System.out.println("Warning: switch length is greater than register length. Only setting first " + jTextField.getText().length() + " bits.");
		}
		String string = this.switchValue.substring(this.switchValue.length() - jTextField.getText().length());
		jTextField.setText(string);
		System.out.println(jTextField.getName() + " is set to: " + string);
	}

    private void loadBootProgram() {
		try {
			InputStream instream = getClass().getResourceAsStream("boot.txt");
			if (instream == null) {
                System.out.println("Unable to get File boot.txt");
                return;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(instream));
			String line;

			while ( (line = br.readLine()) != null) {
				String[] instr = line.split("\\s+");
				int index = Integer.parseInt(instr[0],16) + 8;
				int new_value = Integer.parseInt(instr[1],16);
				System.out.println(new_value + " inserted into memory location " + index);
				memory.insertX(new_value, index);
			}
		} catch (Exception e) {
			System.out.println("Unable to load boot program :: " + e.getMessage());
		}
	}

	private void addSwitches(JPanel bitPanel) {
		this.switchValue = "0".repeat(16);
		this.switches = new JToggleButton[16];
		for (int i = 0; i < this.switches.length; ++i) {
			String string = "" + (this.switches.length - i - 1) + "";
			final JToggleButton jToggleButton = new JToggleButton(string);
			jToggleButton.addItemListener(itemEvent -> {
				int state = itemEvent.getStateChange();
				int value = Frame.this.switches.length - Integer.parseInt(jToggleButton.getText()) - 1;
				Frame.this.switchValue = state == 1
						? Frame.this.switchValue.substring(0, value) + "1" + Frame.this.switchValue.substring(value + 1)
						: Frame.this.switchValue.substring(0, value) + "0" + Frame.this.switchValue.substring(value + 1);
			});
			this.switches[i] = jToggleButton;
			bitPanel.add(jToggleButton);
		}


	}
}
