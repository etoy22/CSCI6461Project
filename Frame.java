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

	private JTextField GPR0BitField;
	private JTextField GPR1BitField;
	private JTextField GPR2BitField;
	private JTextField GPR3BitField;
	private JTextField IX1BitField;
	private JTextField IX2BitField;
	private JTextField IX3BitField;
	private JTextField IRBitField;
	private JTextField PCBitField;
	private JTextField MARBitField;
	private JTextField MBRBitField;
	private JTextField MFRBitField;
	private JTextField CCBitField;
	private JButton IPLButton;


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
		/*
		 * Initalizing the UI elements
		 */
		JPanel contentPane = new JPanel();
		JPanel processingPanel = new JPanel();
		JPanel commandPanel = new JPanel();
		JPanel bitPanel = new JPanel();
		JPanel labelBitPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelBitPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
						.addComponent(bitPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
						.addComponent(commandPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE)
						.addComponent(processingPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1248, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(bitPanel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelBitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(commandPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(processingPanel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
					.addGap(166))
		);


		/*
		 * Setting up JFrame
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/*
		 * Panel Layout
		 */
		bitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		processingPanel.setLayout(null);
		setuplabelBitPanel(labelBitPanel);
		

		contentPane.setLayout(gl_contentPane);

		/*
		 * Add to JFrame
		 */
		this.memory = new Memory();
		this.addGeneralPurposeRegisters(processingPanel);
		this.addIndexRegisters(processingPanel);
		this.addIR(processingPanel);
		this.addPC(processingPanel);
		this.addMAR(processingPanel);
		this.addMBR(processingPanel);
		this.addMFR(processingPanel);
		this.addIPL(processingPanel);
		this.addCC(processingPanel);
		this.addRun(processingPanel);
		this.addStoreAndLoad(commandPanel);
		this.addSwitches(bitPanel);
		this.resetMachineState();		
	}

	private void setuplabelBitPanel(JPanel panel){
		/*
		 * Initalizing the UI elements for plabelBitPanel
		 */
		JLabel lblNewLabel = new JLabel("|____________________Opcode____________________|______R______|______IX______|___I___|______________Address______________|");


		/* 
		 * Setting up labels
		 */
	
		
		lblNewLabel.setBounds(240, 0, 798, 14);

		/*
		 *  Add to bitPanel
		 */
		
		panel.add(lblNewLabel);

	}
	
	private void addRun(JPanel panel){
		/*
		 * Initalizing the UI elements for addRun
		 */

		JButton RUN = new JButton("RUN");

		/*
		 * Set up bounds on addRun
		 */
		RUN.setBounds(856, 79, 120, 72);

		/*
		 * ActionListeners for the Buttons
		 */
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

		/*
		 * Add to JFrame
		 */
		
		panel.add(RUN);
	}

	private void addCC(JPanel panel) {
		/*
		 * Initalizing the UI elements for CC
		 */
		JLabel CCLabel = new JLabel("CC");
		JButton CCButton = new JButton("Load");


		/* 
		 * Setting up textFields for CC
		 */

		CCBitField = new JTextField("0000",4);
		CCBitField.setEditable(false);
		/*
		 * Set up bounds on CC
		 */
		CCLabel.setBounds(   512, 196, 48, textFieldHeight);
		CCButton.setBounds(  558, 196, 80, 23);
		this.CCBitField.setBounds(640, 197, textFieldWidth, textFieldHeight);

		/*
		 * ActionListeners for the Buttons
		 */

		CCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.CCBitField);	
			}
		});

		/*
		 * Add to JFrame
		 */
		panel.add(CCLabel);
		panel.add(CCButton);
		panel.add(this.CCBitField);
		
	}

	private void addGeneralPurposeRegisters(JPanel panel) {

		/* 
		 * Initalizing the UI elements for GPR
		 */
		JLabel GPR0Label = new JLabel("GPR 0");
		JLabel GPR1Label = new JLabel("GPR 1");
		JLabel GPR2Label = new JLabel("GPR 2");
		JLabel GPR3Label = new JLabel("GPR 3");
		JButton GPR0Button = new JButton("Load");
		JButton GPR1Button = new JButton("Load");;
		JButton GPR2Button = new JButton("Load");;
		JButton GPR3Button = new JButton("Load");;


		/*
		 * Setting up textFields for GPR
		 */

		this.GPR0BitField = new JTextField(16);
		this.GPR0BitField.setName("gpr0");
		this.GPR0BitField.setEditable(false);

		this.GPR1BitField = new JTextField(16);
		this.GPR1BitField.setName("gpr1");
		this.GPR1BitField.setEditable(false);

		this.GPR2BitField = new JTextField(16);
		this.GPR2BitField.setName("gpr2");
		this.GPR2BitField.setEditable(false);
		
		this.GPR3BitField = new JTextField(16);
		this.GPR3BitField.setName("gpr3");
		this.GPR3BitField.setEditable(false);

		/*
		 * Set up bounds on GPR  
		 */

		GPR0Label.setBounds(   (int) (screenInc*1), 11, 48, textFieldHeight);
		GPR0Button.setBounds(  174, 11, 80, 23);
		GPR0BitField.setBounds((int) (screenInc*2), 11, textFieldWidth, textFieldHeight);
		GPR1Label.setBounds(   (int) (screenInc*1  ), 45, 48, textFieldHeight);
		GPR1Button.setBounds(  174, 45, 80, 23);
		GPR1BitField.setBounds((int) (screenInc*2  ), 45, textFieldWidth, textFieldHeight);
		GPR2Label.setBounds(   (int) (screenInc*1  ), 79, 48, textFieldHeight);
		GPR2Button.setBounds(  174, 79, 80, 23);
		GPR2BitField.setBounds((int) (screenInc*2  ), 79, textFieldWidth, textFieldHeight);
		GPR3Label.setBounds(   (int) (screenInc*1  ), 113, 48, textFieldHeight);
		GPR3Button.setBounds(  174, 113, 80, 23);
		GPR3BitField.setBounds((int) (screenInc*2  ), 113, textFieldWidth, textFieldHeight);
		
		/* 
		 * ActionListeners for the Buttons 
		 */
		GPR0Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GPRController(Frame.this.GPR0BitField);
			}
		});

		GPR1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GPRController(Frame.this.GPR1BitField);
			}
		});

		GPR2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GPRController(Frame.this.GPR2BitField);
			}
		});

		GPR3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GPRController(Frame.this.GPR3BitField);
			}
		});

		/* 
		 *  Add to JFrame
		 */
		//  Buttons
		panel.add(GPR0Button);
		panel.add(GPR1Button);
		panel.add(GPR2Button);
		panel.add(GPR3Button);

		//Labels

		panel.add(GPR0Label);
		panel.add(GPR1Label);
		panel.add(GPR2Label);
		panel.add(GPR3Label);

		//Fields
		panel.add(GPR0BitField);
		panel.add(GPR1BitField);
		panel.add(GPR2BitField);
		panel.add(this.GPR3BitField);

	}
	
	public void GPRController(JTextField textField){
		/* 
		* The command that all GPR run when the button load button is pressed
		*/
		Frame.this.loadSwitchValue(textField);
	}

	private void addIndexRegisters(JPanel panel) {
		/* 
		 * Initalizing the UI elements for IX
		 */
		JLabel IX1Label = new JLabel("IX1");
		JLabel IX2Label = new JLabel("IX2");
		JLabel IX3Label = new JLabel("IX3");
		JButton IX1Button = new JButton("Load");;
		JButton IX2Button = new JButton("Load");;
		JButton IX3Button = new JButton("Load");;

		/*
		 * Setting up textFields for IX
		 */

		this.IX1BitField = new JTextField(16);
		this.IX1BitField.setName("ix1");
		this.IX1BitField.setEditable(false);

		this.IX2BitField = new JTextField(16);
		this.IX2BitField.setName("ix2");
		this.IX2BitField.setEditable(false);

		this.IX3BitField = new JTextField(16);
		this.IX3BitField.setName("ix3");
		this.IX3BitField.setEditable(false);


		/*
		 * Set up bounds on IX
		 */

		IX1Label.setBounds(   (int) (screenInc*4  ), 11, 48, textFieldHeight);
		IX1Button.setBounds(  558, 11, 80, 23);
		IX1BitField.setBounds((int) (screenInc*5  ), 11, textFieldWidth, textFieldHeight);

		IX2Label.setBounds(   (int) (screenInc*4  ), 45, 48, textFieldHeight);
		IX2Button.setBounds(  558, 45, 80, 23);
		IX2BitField.setBounds((int) (screenInc*5  ), 45, textFieldWidth, textFieldHeight);

		IX3Label.setBounds(   (int) (screenInc*4  ), 79, 48, textFieldHeight);
		IX3Button.setBounds(  558, 79, 80, 23);
		IX3BitField.setBounds((int) (screenInc*5  ), 79, textFieldWidth, textFieldHeight);

		/* 
		 * ActionListeners for the Buttons
		 */

		IX1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.IX1BitField);
				System.out.println(IX1BitField.getText());
				CPU.change_IX(1,Integer.parseInt(IX1BitField.getText()));
			}
		});

		IX2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.IX2BitField);	
				CPU.change_IX(2,Integer.parseInt(IX1BitField.getText()));
			}
		});

		
		IX3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.IX3BitField);
				CPU.change_IX(3,Integer.parseInt(IX1BitField.getText()));


			}
		});

		/* 
		 * Add to JFrame
		 */

		panel.add(IX1Label);
		panel.add(IX1Button);
		panel.add(IX1BitField);

		panel.add(IX2Label);
		panel.add(IX2Button);
		panel.add(IX2BitField);

		
		panel.add(IX3Label);
		panel.add(IX3Button);
		panel.add(IX3BitField);

	}

	private void addIR(JPanel panel) {
		/*
		 * Initalizing the UI elements for IR
		 */
		JLabel IRLabel = new JLabel("IR");

		/*
		 * Setting up textFields for IR
		 */

		this.IRBitField = new JTextField(16);
		this.IRBitField.setName("ir");
		this.IRBitField.setEditable(false);
		/*
		 * Set up bounds on IR
		 */
		IRLabel.setBounds(   (int) (screenInc*1  ), 264, 48, textFieldHeight);
		IRBitField.setBounds((int) (screenInc*2  ), 264, textFieldWidth, textFieldHeight);

		/*
		 * Add to JFrame
		 */
		panel.add(IRLabel);
		panel.add(IRBitField);
	}

	private void addPC(JPanel panel) {
		/*
		 * Initalizing the UI elements for PC
		 */
		JLabel PCLabel = new JLabel("PC");
		JButton PCButton = new JButton("Load");;

		/* 
		* Setting up textFields for PC
		*/		

		this.PCBitField = new JTextField(12);
		this.PCBitField.setName("pc");
		this.PCBitField.setEditable(false);

		/*
		 * Set up bounds for PC
		 */

		PCLabel.setBounds(   (int) (screenInc*1  ), 162, 48, textFieldHeight);
		PCButton.setBounds(  174, 162, 80, 23);
		PCBitField.setBounds((int) (screenInc*2  ), 162, textFieldWidth, textFieldHeight);

		/*
		 * ActionListeners for the Buttons
		 */

		PCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.PCBitField);	
			}
		});

		/*
		 * Add to JFrame
		 */
		panel.add(PCLabel);
		panel.add(PCButton);
		panel.add(PCBitField);
	}

	private void addMAR(JPanel panel) {
		/*
		 * Initalizing the UI elements for MAR
		 */
		JLabel MARLabel = new JLabel("MAR");
		this.MARBitField = new JTextField(12);
		JButton MARButton = new JButton("Load");

		/* 
		 * Setting up textFields for MAR
		 */
		this.MARBitField.setName("mar");
		this.MARBitField.setEditable(false);

		/*
		 * Set up bounds on MAR
		 */

		MARLabel.setBounds(   (int) (screenInc*1), 196, 48, textFieldHeight);
		MARButton.setBounds(  174, 196, 80, 23);
		MARBitField.setBounds((int) (screenInc*2), 196, textFieldWidth, textFieldHeight);

		/*
		 * ActionListeners for the Buttons
		 */
		MARButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.MARBitField);				
			}
		});

		/*
		 * Add to JFrame
		 */
		panel.add(MARLabel);
		panel.add(MARButton);
		panel.add(MARBitField);
	}

	private void addMBR(JPanel panel) {
		/*
		 * Initalizing the UI elements for MBR
		 */
		JLabel MBRLabel = new JLabel("MBR");
		this.MBRBitField = new JTextField(16);
		JButton MBRButton = new JButton("Load");

		/* 
		 * Setting up textFields for MBR
		 */

		this.MBRBitField.setName("mbr");
		this.MBRBitField.setEditable(false);

		/*
		 * Set up bounds on MBR
		 */
		MBRLabel.setBounds((int) (screenInc*1), 230, 48, textFieldHeight);
		MBRButton.setBounds(174, 230, 80, 23);
		MBRBitField.setBounds((int) (screenInc*2), 230, textFieldWidth, textFieldHeight);
		/*
		 * ActionListeners for the Buttons
		 */

		MBRButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadSwitchValue(Frame.this.MBRBitField);

			}
		});

		/*
		 * Add to JFrame
		 */
		panel.add(MBRLabel);
		panel.add(MBRButton);
		panel.add(MBRBitField);
	}

	private void addMFR(JPanel panel) {
		/*
		 * Initalizing the UI elements for MFR
		 */
		JLabel MFRLabel = new JLabel("MFR");
		this.MFRBitField = new JTextField(16);

		/* 
		 * Setting up textFields for MFR
		 */

		this.MFRBitField.setName("mfr");
		this.MFRBitField.setEditable(false);
		/*
		 * Set up bounds on MFR
		 */

		MFRLabel.setBounds(512, 162, 120, textFieldHeight);
		MFRBitField.setBounds(640, 162, textFieldWidth, textFieldHeight);
		/*
		 * Add to JFrame
		 */


		panel.add(MFRLabel);
		panel.add(MFRBitField);
	}

	private void addIPL(JPanel panel) {
		/*
		 * Initalizing the UI elements for IPL
		 */
		this.IPLButton = new JButton("IPL");


		/*
		 * Set up bounds on IPL
		 */
		this.IPLButton.setBounds(screenInc*2, 300, 120, textFieldHeight*2);


		/*
		 * Add ActionListener
		 */

        this.IPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.this.loadBootProgram();
			}
		});
		/*
		 * Add to JFrame
		 */
		panel.add(IPLButton);

	}

	private void addStoreAndLoad(JPanel panel) {
		/*
		 * Initalizing the UI elements for addStoreAndLoad
		 */
		JButton storeButton = new JButton("Store");
		JButton loadButton = new JButton("Load");
		JButton nextStepButton = new JButton("Next Step");
		JButton resetButton = new JButton("Reset");

		/*
		 * ActionListeners for the Buttons
		 */
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Value=Integer.parseInt(MBRBitField.getText(),2);
				int Index=Integer.parseInt(MARBitField.getText(),2);
	            memory.insertX(Value, Index);

			}
		});

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
			}
		});


		nextStepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleStep();
			}
		});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetMachineState();
			}
		});
		/*
		 * Add to JFrame
		 */
		panel.add(storeButton);
		panel.add(loadButton);
		panel.add(nextStepButton);
		panel.add(nextStepButton);
		panel.add(resetButton);
	}
	
	private void singleStep() {
		/*
		 * Variable for Single step
		 */
		int data;
		String binString;
		String result;
		String format; 
		
		/*
		 * Actions needed to preform a singleStep
		 */

        MARBitField.setText(PCBitField.getText());
        data = memory.getValue(Integer.parseInt(PCBitField.getText(), 2));
        binString = Integer.toBinaryString(data);

        binString = binString.length() == MBRBitField.getColumns() ? binString : "0".repeat(MBRBitField.getColumns()-binString.length()) + binString;
        MBRBitField.setText(binString);
        IRBitField.setText(MBRBitField.getText());
        CPU.instruction(IRBitField.getText());
		result = Integer.toBinaryString(Integer.parseInt(PCBitField.getText(), 2)+1);
		format = ("000000000000" + result).substring(result.length());
        PCBitField.setText(format);
        refresh();
    }

	private void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }

	private void resetMachineState() {
		/*
		 * Resets machine
		 */
		this.GPR0BitField.setText("0".repeat(16));
		this.GPR1BitField.setText("0".repeat(16));
		this.GPR2BitField.setText("0".repeat(16));
		this.GPR3BitField.setText("0".repeat(16));
		this.IX1BitField.setText("0".repeat(16));
		this.IX2BitField.setText("0".repeat(16));
		this.IX3BitField.setText("0".repeat(16));
		this.PCBitField.setText("0".repeat(12));
		this.MARBitField.setText("0".repeat(12));
		this.MBRBitField.setText("0".repeat(16));
		this.IRBitField.setText("0".repeat(16));
		this.MFRBitField.setText("0".repeat(4));
		this.switchValue = "0".repeat(16);
		for (JToggleButton jToggleButton : this.switches) {
			jToggleButton.setSelected(false);
		}
	}

	public void setRegisterValue(JTextField jTextField, int n) {
		/*
		 * Check for valid length
		 */
		if (jTextField.getText().length() <= 0) {
			System.out.println("Error setting register value: invalid length");
			return;
		}
		/*
		 * Initalizing Values
		 */
		String string = Integer.toBinaryString(n);
		int n2 = jTextField.getText().length() - string.length();
		String string2 = "0".repeat(n2) + string;

		//Set JTextField
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
