package SkiResort;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;

import javax.swing.*;
import javax.swing.border.*;

public class SkiResortGUI {
	SkiResortDatabase db = new SkiResortDatabase();
	ButtonHandler bh = new ButtonHandler();

	String keyTxt = "Keyword:";
	String searchTxt = "Search";
	
	String addTxt = "New";
	String editTxt = "Edit";
	String delTxt = "Remove";
	String selClearTxt = "Clear Choice";
	
	String loadTxt = "Load File";
	String saveTxt = "Save File";
	String eraseTxt = "Erase File";
	String ExitTxt = "Safe Close";
	
	String submitTxt = "Submit";
	String cancelTxt = "Cancel";
	
	// CardLayout & JTabbedPane Components
	
	final JFrame program = new JFrame("Mt Buller Resort");
	JPanel mainPan = new JPanel(), tabPan = new JPanel(), 
			addAccomPan = new JPanel(), editAccomPan = new JPanel(), 
			addCustPan = new JPanel(), editCustPan = new JPanel(), 
			addPackPan = new JPanel(), editPackPan = new JPanel();
	CardLayout cards = new CardLayout();	
	JTabbedPane tabs = new JTabbedPane();
	
		//Accommodation Tab Components
		
		JPanel accommodationTab = new JPanel(); 
		JPanel accomInputPan = new JPanel(), accomDisplayPan = new JPanel(), accomButtonsPan = new JPanel();
		JButton addAccomBtn = new JButton(addTxt), editAccomBtn = new JButton(editTxt), delAccomBtn = new JButton(delTxt), clearSelAccomBtn = new JButton(selClearTxt), 
				closeAccomBtn = new JButton(ExitTxt), loadAccomBtn = new JButton(loadTxt), saveAccomBtn = new JButton(saveTxt), eraseAccomBtn = new JButton(eraseTxt);
		JLabel searchAccomLbl = new JLabel(keyTxt);
		JTextField searchAccomTF = new JTextField(20);
		JButton searchAccomBtn = new JButton(searchTxt);
		JLabel accomNotice = new JLabel("Click a Accommodations from the list for a Travel Package.", SwingConstants.CENTER);
		
		//Customer Tab Components
		
		JPanel customerTab = new JPanel();
		JPanel custInputPan = new JPanel(), custDisplayPan = new JPanel(), custButtonsPan = new JPanel();
		JButton addCustBtn = new JButton(addTxt), editCustBtn = new JButton(editTxt),  delCustBtn = new JButton(delTxt), clearSelCustBtn = new JButton(selClearTxt),
				closeCustBtn = new JButton(ExitTxt), loadCustBtn = new JButton(loadTxt), saveCustBtn = new JButton(saveTxt), eraseCustBtn = new JButton(eraseTxt);
		JLabel searchCustLbl = new JLabel(keyTxt);
		JTextField searchCustTF = new JTextField(20);
		JButton searchCustBtn = new JButton(searchTxt);
		JLabel custNotice = new JLabel("Click a Customers from the list for a Travel Package.", SwingConstants.CENTER);
		
		//Package Tab Components
		
		JPanel packageTab = new JPanel();
		JPanel packInputPan = new JPanel(), packDisplayPan = new JPanel(), packButtonsPan = new JPanel();
		JButton addPackBtn = new JButton(addTxt), editPackBtn = new JButton(editTxt),  delPackBtn = new JButton(delTxt), clearSelPackBtn = new JButton(selClearTxt),
				closePackBtn = new JButton(ExitTxt), loadPackBtn = new JButton(loadTxt), savePackBtn = new JButton(saveTxt), erasePackBtn = new JButton(eraseTxt);
		JLabel searchPackLbl = new JLabel(keyTxt);
		JTextField searchPackTF = new JTextField(20);
		JButton searchPackBtn = new JButton(searchTxt);
		JLabel packNotice = new JLabel("Select an Accommodation and Customer to make a Travel Package.", SwingConstants.CENTER);
		
	// Add Accommodation Components
		
	JPanel addAccomPanA = new JPanel(), addAccomPanB = new JPanel(), addAccomPanC = new JPanel(), addAccomPanD = new JPanel(), addAccomPanE = new JPanel(), addAccomPanF = new JPanel(), addAccomPanG = new JPanel(), addAccomPanH = new JPanel(), addAccomMenuBtnPan = new JPanel();
	JButton subNewAccomBtn = new JButton(submitTxt), cancelNewAccomBtn = new JButton(cancelTxt),
			accomAddNameQBtn = new JButton("?"),
			accomAddDescQBtn = new JButton("?"),
			accomAddTypeQBtn = new JButton("?"),
			accomAddCostQBtn = new JButton("?"),
			accomAddMountQBtn = new JButton("?"),
			accomAddSnowQBtn = new JButton("?"),
			accomAddKidsFreeQBtn = new JButton("?"),
			accomAddInternetQBtn = new JButton("?");
	JLabel accomAddNameLbl = new JLabel("Name:"), 
			accomAddDescLbl = new JLabel("Description:"), 
			accomAddTypeLbl = new JLabel("Type:"), 
			accomAddCostLbl = new JLabel("Daily Cost:"), 
			accomAddMountLbl = new JLabel("On the Mountain?"), 
			accomAddSnowLbl = new JLabel("Snow Guarantee?"), 
			accomAddKidsFreeLbl = new JLabel("Kids Stay Free?"),
			accomAddInternetLbl = new JLabel("Internet Access?");
	JTextField accomAddNameTF = new JTextField(20),  accomAddCostTF = new JTextField(8);
	JTextArea accomAddDescTF = new JTextArea(2, 20);
	JScrollPane accomAddDescSRL = new JScrollPane(accomAddDescTF, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	JComboBox<ENUMaccomType> accomAddTypeDrop = new JComboBox<ENUMaccomType>(ENUMaccomType.values());
	JCheckBox accomAddMountCheck = new JCheckBox(), accomAddSnowCheck = new JCheckBox(), accomAddKidsFreeCheck = new JCheckBox(), accomAddInternetCheck = new JCheckBox();
	
		// Edit Accommodation Components
		
		JPanel editAccomPanA = new JPanel(), editAccomPanB = new JPanel(), editAccomPanC = new JPanel(), editAccomPanD = new JPanel(), editAccomPanE = new JPanel(), editAccomPanF = new JPanel(), editAccomPanG = new JPanel(), editAccomPanH = new JPanel(), editAccomMenuBtnPan = new JPanel();
		JButton subEditAccomBtn = new JButton(submitTxt), cancelEditAccomBtn = new JButton(cancelTxt),
				accomEditNameQBtn = new JButton("?"),
				accomEditDescQBtn = new JButton("?"),
				accomEditTypeQBtn = new JButton("?"),
				accomEditCostQBtn = new JButton("?"),
				accomEditMountQBtn = new JButton("?"),
				accomEditSnowQBtn = new JButton("?"),
				accomEditKidsFreeQBtn = new JButton("?"),
				accomEditInternetQBtn = new JButton("?");
		JLabel accomEditNameLbl = new JLabel("Name:"), 
				accomEditDescLbl = new JLabel("Description:"), 
				accomEditTypeLbl = new JLabel("Type:"), 
				accomEditCostLbl = new JLabel("Daily Cost:"), 
				accomEditMountLbl = new JLabel("On the Mountain?"),
				accomEditSnowLbl = new JLabel("Snow Guarantee?"), 
				accomEditKidsFreeLbl = new JLabel("Kids Stay Free?"),
				accomEditInternetLbl = new JLabel("Internet Access?");
		JTextField accomEditNameTF = new JTextField(20), accomEditCostTF = new JTextField(8);
		JTextArea accomEditDescTF = new JTextArea(2, 20);
		JScrollPane accomEditDescSRL = new JScrollPane(accomEditDescTF, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JComboBox<ENUMaccomType> accomEditTypeDrop = new JComboBox<ENUMaccomType>(ENUMaccomType.values());
		JCheckBox accomEditMountCheck = new JCheckBox(), accomEditSnowCheck = new JCheckBox(), accomEditKidsFreeCheck = new JCheckBox(), accomEditInternetCheck = new JCheckBox();

	// Add Customer Components
	
	JPanel addCustPanA = new JPanel(), addCustPanB = new JPanel(), addCustPanC = new JPanel(), addCustPanD = new JPanel(), addCustPanE = new JPanel(), addCustPanF = new JPanel(), addCustMenuBtnPan = new JPanel();
	JButton subNewCustBtn = new JButton(submitTxt), cancelNewCustBtn = new JButton(cancelTxt),
			custAddFNameQBtn = new JButton("?"),
			custAddLNameQBtn = new JButton("?"),
			custAddAgeQBtn = new JButton("?"),
			custAddExpQBtn = new JButton("?"),
			custAddPhoneQBtn = new JButton("?"),
			custAddEmailQBtn = new JButton("?");
	JLabel custAddFNameLbl = new JLabel("First Name: "), 
			custAddLNameLbl = new JLabel("Last Name:"), 
			custAddAgeLbl = new JLabel("Age:"), 
			custAddExpLbl = new JLabel("Skiing Experience:"), 
			custAddPhoneLbl = new JLabel("Phone Number:"), 
			custAddEmailLbl = new JLabel("Email Address:");
	JTextField custAddFNameTF = new JTextField(20), custAddLNameTF = new JTextField(20), custAddAgeTF = new JTextField(8), custAddPhoneTF = new JTextField(20), custAddEmailTF = new JTextField(20);
	JComboBox<ENUMexperience> custAddExpDrop = new JComboBox<ENUMexperience>(ENUMexperience.values());

		// Edit Customer Components
		
		JPanel editCustPanA = new JPanel(), editCustPanB = new JPanel(), editCustPanC = new JPanel(), editCustPanD = new JPanel(), editCustPanE = new JPanel(), editCustPanF = new JPanel(), editCustMenuBtnPan = new JPanel();
		JButton subEditCustBtn = new JButton(submitTxt), cancelEditCustBtn = new JButton(cancelTxt),
				custEditFNameQBtn = new JButton("?"),
				custEditLNameQBtn = new JButton("?"),
				custEditAgeQBtn = new JButton("?"),
				custEditExpQBtn = new JButton("?"),
				custEditPhoneQBtn = new JButton("?"),
				custEditEmailQBtn = new JButton("?");
		JLabel custEditFNameLbl = new JLabel("First Name: "),
				custEditLNameLbl = new JLabel("Last Name:"), 
				custEditAgeLbl = new JLabel("Age:"), 
				custEditExpLbl = new JLabel("Skiing Experience:"), 
				custEditPhoneLbl = new JLabel("Phone Number:"), 
				custEditEmailLbl = new JLabel("Email Address:");
		JTextField custEditFNameTF = new JTextField(20), custEditLNameTF = new JTextField(20), custEditAgeTF = new JTextField(8), custEditPhoneTF = new JTextField(20), custEditEmailTF = new JTextField(20);
		JComboBox<ENUMexperience> custEditExpDrop = new JComboBox<ENUMexperience>(ENUMexperience.values());

	// Add Travel Package Components
	
	JPanel addPackPanA = new JPanel(), addPackPanB = new JPanel(), addPackPanC = new JPanel(), addPackPanD = new JPanel(), addPackPanE = new JPanel(), addPackPanF = new JPanel(), addPackMenuBtnPan = new JPanel();
	JButton subNewPackBtn = new JButton(submitTxt), cancelNewPackBtn = new JButton(cancelTxt),
			packAddADateQBtn = new JButton("?"),
			packAddDDateQBtn = new JButton("?"),
			packAddLessonsQBtn = new JButton("?"),
			packAddLiftPassQBtn = new JButton("?");
	JLabel packAddNameLbl = new JLabel("Customer:", SwingConstants.RIGHT),
			packAddNameRLbl = new JLabel(""), 
			packAddAccomLbl = new JLabel("Accommodation:", SwingConstants.RIGHT),
			packAddAccomRLbl = new JLabel(""), 
			packAddADateLbl = new JLabel("Arrival Date: "), 
			packAddDDateLbl = new JLabel("Departure Date: "), 
			packAddLiftPassLbl = new JLabel("Lift Pass: "), 
			packAddLessonsLbl = new JLabel("Number of Lessons: ");
	JTextField packAddADateTF = new JTextField(10), packAddDDateTF = new JTextField(10), packAddLessonsTF = new JTextField(10);
	JComboBox<ENUMliftPassValues> packAddLiftPassDrop = new JComboBox<ENUMliftPassValues>(ENUMliftPassValues.values());

		// Edit Travel Package Components
		
		JPanel editPackPanA = new JPanel(), editPackPanB = new JPanel(), editPackPanC = new JPanel(), editPackPanD = new JPanel(), editPackPanE = new JPanel(), editPackPanF = new JPanel(), editPackMenuBtnPan = new JPanel();
		JButton subEditPackBtn = new JButton(submitTxt), cancelEditPackBtn = new JButton(cancelTxt),
				packEditADateQBtn = new JButton("?"),
				packEditDDateQBtn = new JButton("?"),
				packEditLessonsQBtn = new JButton("?"),
				packEditLiftPassQBtn = new JButton("?");
		JLabel packEditNameLbl = new JLabel("Customer:", SwingConstants.RIGHT), 
				packEditNameRLbl = new JLabel(""), 
				packEditAccomLbl = new JLabel("Accommodation:", SwingConstants.RIGHT),
				packEditAccomRLbl = new JLabel(""), 
				packEditADateLbl = new JLabel("Arrival Date: "), 
				packEditDDateLbl = new JLabel("Departure Date: "), 
				packEditLiftPassLbl = new JLabel("Lift Pass: "), 
				packEditLessonsLbl = new JLabel("Number of Lessons: ");
		JTextField packEditADateTF = new JTextField(10), packEditDDateTF = new JTextField(10), packEditLessonsTF = new JTextField(10);
		JComboBox<ENUMliftPassValues> packEditLiftPassDrop = new JComboBox<ENUMliftPassValues>(ENUMliftPassValues.values());
	
	public SkiResortGUI() {
		
		/* 
		 * I feel like I could have handled this cleaner than I have, possibly using Boolean expressions to distinguish between editing and adding 
		 * new accommodations. I decided to stick to what I knew would work here. Keeping the cards, buttons, inputs all separate was a sure fire
		 * way to ensure that I did not encounter any unknown bugs, even if it took a bit more coding.
		 */
		
		db.loadDatabase();
		
		// Creates Tabs & Cards Construction
		
		mainPan.setLayout(cards);
		mainPan.add(tabPan, "TB");
		tabPan.setLayout(new BorderLayout());
		tabPan.add(tabs, BorderLayout.CENTER);
		tabs.addTab("Accommodations", accommodationTab);
		tabs.addTab("Customers", customerTab);
		tabs.addTab("Travel Packs",packageTab);
		mainPan.add(addAccomPan, "AA");
		mainPan.add(editAccomPan, "EA");
		mainPan.add(addCustPan, "AC");
		mainPan.add(editCustPan, "EC");
		mainPan.add(addPackPan, "AP");
		mainPan.add(editPackPan, "EP");
		cards.show(mainPan, "TB");

		// Accommodation Tab Construction
		
		accommodationTab.setLayout(new BorderLayout());
		accommodationTab.add(accomInputPan, BorderLayout.NORTH);
		accomInputPan.add(searchAccomLbl, BorderLayout.WEST);
		accomInputPan.add(searchAccomTF, BorderLayout.CENTER);
		accomInputPan.add(searchAccomBtn, BorderLayout.EAST);
		searchAccomBtn.addActionListener(bh);
		accommodationTab.add(accomDisplayPan, BorderLayout.CENTER);
		db.accomScroll.setBorder(new TitledBorder("List of Accommodations"));
		accomDisplayPan.setLayout(new BorderLayout());
		accomDisplayPan.add(db.accomScroll, BorderLayout.CENTER);
		accomDisplayPan.add(accomNotice, BorderLayout.SOUTH);
		accommodationTab.add(accomButtonsPan, BorderLayout.SOUTH);

		accomButtonsPan.setLayout(new GridLayout(2, 4));
		accomButtonsPan.add(addAccomBtn);
		addAccomBtn.addActionListener(bh);
		accomButtonsPan.add(editAccomBtn);
		editAccomBtn.addActionListener(bh);
		accomButtonsPan.add(delAccomBtn);
		delAccomBtn.addActionListener(bh);
		accomButtonsPan.add(clearSelAccomBtn);
		clearSelAccomBtn.addActionListener(bh);
		accomButtonsPan.add(loadAccomBtn);
		loadAccomBtn.addActionListener(bh);
		accomButtonsPan.add(saveAccomBtn);
		saveAccomBtn.addActionListener(bh);
		accomButtonsPan.add(eraseAccomBtn);
		eraseAccomBtn.addActionListener(bh);
		accomButtonsPan.add(closeAccomBtn);
		closeAccomBtn.addActionListener(bh);
			
			// Add Accommodations Card Construction
	
			addAccomPan.setLayout(new GridLayout(9, 1));
			addAccomPan.add(addAccomPanA);
			addAccomPan.add(addAccomPanB);
			addAccomPan.add(addAccomPanC);
			addAccomPan.add(addAccomPanD);
			addAccomPan.add(addAccomPanE);
			addAccomPan.add(addAccomPanF);
			addAccomPan.add(addAccomPanG);
			addAccomPan.add(addAccomPanH);
			addAccomPan.add(addAccomMenuBtnPan);

			addAccomPanA.add(accomAddNameLbl);
			addAccomPanA.add(accomAddNameQBtn);
			accomAddNameQBtn.addActionListener(bh);
			addAccomPanA.add(accomAddNameTF);
			addAccomPanB.add(accomAddDescLbl);
			addAccomPanB.add(accomAddDescQBtn);
			accomAddDescQBtn.addActionListener(bh);
			addAccomPanB.add(accomAddDescSRL);
				accomAddDescTF.setLineWrap(true);
				accomAddDescTF.setWrapStyleWord(true);
			addAccomPanC.add(accomAddTypeLbl);
			addAccomPanC.add(accomAddTypeQBtn);
			accomAddTypeQBtn.addActionListener(bh);
			addAccomPanC.add(accomAddTypeDrop);
			addAccomPanD.add(accomAddCostLbl);
			addAccomPanD.add(accomAddCostQBtn);
			accomAddCostQBtn.addActionListener(bh);
			addAccomPanD.add(accomAddCostTF);
			addAccomPanE.add(accomAddMountLbl);
			addAccomPanE.add(accomAddMountQBtn);
			accomAddMountQBtn.addActionListener(bh);
			addAccomPanE.add(accomAddMountCheck);
			addAccomPanF.add(accomAddSnowLbl);
			addAccomPanF.add(accomAddSnowQBtn);
			accomAddSnowQBtn.addActionListener(bh);
			addAccomPanF.add(accomAddSnowCheck);
			addAccomPanG.add(accomAddKidsFreeLbl);
			addAccomPanG.add(accomAddKidsFreeQBtn);
			accomAddKidsFreeQBtn.addActionListener(bh);
			addAccomPanG.add(accomAddKidsFreeCheck);
			addAccomPanH.add(accomAddInternetLbl);
			addAccomPanH.add(accomAddInternetQBtn);
			accomAddInternetQBtn.addActionListener(bh);
			addAccomPanH.add(accomAddInternetCheck);
			
			addAccomMenuBtnPan.add(subNewAccomBtn);
			subNewAccomBtn.addActionListener(bh);
			addAccomMenuBtnPan.add(cancelNewAccomBtn);
			cancelNewAccomBtn.addActionListener(bh);
			
			// Edit Accommodations Card Construction

			editAccomPan.setLayout(new GridLayout(9, 1));
			editAccomPan.add(editAccomPanA);
			editAccomPan.add(editAccomPanB);
			editAccomPan.add(editAccomPanC);
			editAccomPan.add(editAccomPanD);
			editAccomPan.add(editAccomPanE);
			editAccomPan.add(editAccomPanF);
			editAccomPan.add(editAccomPanG);
			editAccomPan.add(editAccomPanH);
			editAccomPan.add(editAccomMenuBtnPan);

			editAccomPanA.add(accomEditNameLbl);
			editAccomPanA.add(accomEditNameQBtn);
			accomEditNameQBtn.addActionListener(bh);
			editAccomPanA.add(accomEditNameTF);
			editAccomPanB.add(accomEditDescLbl);
			editAccomPanB.add(accomEditDescQBtn);
			accomEditDescQBtn.addActionListener(bh);
			editAccomPanB.add(accomEditDescTF);
			editAccomPanC.add(accomEditTypeLbl);
			editAccomPanC.add(accomEditTypeQBtn);
			accomEditTypeQBtn.addActionListener(bh);
			editAccomPanC.add(accomEditTypeDrop);
			editAccomPanD.add(accomEditCostLbl);
			editAccomPanD.add(accomEditCostQBtn);
			accomEditCostQBtn.addActionListener(bh);
			editAccomPanD.add(accomEditCostTF);
			editAccomPanE.add(accomEditMountLbl);
			editAccomPanE.add(accomEditMountQBtn);
			accomEditMountQBtn.addActionListener(bh);
			editAccomPanE.add(accomEditMountCheck);
			editAccomPanF.add(accomEditSnowLbl);
			editAccomPanF.add(accomEditSnowQBtn);
			accomEditSnowQBtn.addActionListener(bh);
			editAccomPanF.add(accomEditSnowCheck);
			editAccomPanG.add(accomEditKidsFreeLbl);
			editAccomPanG.add(accomEditKidsFreeQBtn);
			accomEditKidsFreeQBtn.addActionListener(bh);
			editAccomPanG.add(accomEditKidsFreeCheck);
			editAccomPanH.add(accomEditInternetLbl);
			editAccomPanH.add(accomEditInternetQBtn);
			accomEditInternetQBtn.addActionListener(bh);
			editAccomPanH.add(accomEditInternetCheck);
			
			editAccomMenuBtnPan.add(subEditAccomBtn);
			subEditAccomBtn.addActionListener(bh);
			editAccomMenuBtnPan.add(cancelEditAccomBtn);
			cancelEditAccomBtn.addActionListener(bh);
			
		// Customer Tab Construction
		
		customerTab.setLayout(new BorderLayout());
		customerTab.add(custInputPan, BorderLayout.NORTH);
		custInputPan.add(searchCustLbl, BorderLayout.WEST);
		custInputPan.add(searchCustTF, BorderLayout.CENTER);
		custInputPan.add(searchCustBtn, BorderLayout.EAST);
		searchCustBtn.addActionListener(bh);
		customerTab.add(custDisplayPan, BorderLayout.CENTER);
		custDisplayPan.setLayout(new BorderLayout());
		db.custScroll.setBorder(new TitledBorder("List of Customers"));
		custDisplayPan.add(db.custScroll, BorderLayout.CENTER);
		custDisplayPan.add(custNotice, BorderLayout.SOUTH);
		customerTab.add(custButtonsPan, BorderLayout.SOUTH);

		custButtonsPan.setLayout(new GridLayout(2,4));
		custButtonsPan.add(addCustBtn);
		addCustBtn.addActionListener(bh);
		custButtonsPan.add(editCustBtn);
		editCustBtn.addActionListener(bh);
		custButtonsPan.add(delCustBtn);
		delCustBtn.addActionListener(bh);
		custButtonsPan.add(clearSelCustBtn);
		clearSelCustBtn.addActionListener(bh);
		custButtonsPan.add(loadCustBtn);
		loadCustBtn.addActionListener(bh);
		custButtonsPan.add(saveCustBtn);
		saveCustBtn.addActionListener(bh);
		custButtonsPan.add(eraseCustBtn);
		eraseCustBtn.addActionListener(bh);
		custButtonsPan.add(closeCustBtn);
		closeCustBtn.addActionListener(bh);
		
			// Add Customer Card Construction

			addCustPan.setLayout(new GridLayout(7, 1));
			addCustPan.add(addCustPanA);
			addCustPan.add(addCustPanB);
			addCustPan.add(addCustPanC);
			addCustPan.add(addCustPanD);
			addCustPan.add(addCustPanE);
			addCustPan.add(addCustPanF);
			addCustPan.add(addCustMenuBtnPan);
	
			addCustPanA.add(custAddFNameLbl);
			addCustPanA.add(custAddFNameQBtn);
			custAddFNameQBtn.addActionListener(bh);
			addCustPanA.add(custAddFNameTF);
			addCustPanB.add(custAddLNameLbl);
			addCustPanB.add(custAddLNameQBtn);
			custAddLNameQBtn.addActionListener(bh);
			addCustPanB.add(custAddLNameTF);
			addCustPanC.add(custAddAgeLbl);
			addCustPanC.add(custAddAgeQBtn);
			custAddAgeQBtn.addActionListener(bh);
			addCustPanC.add(custAddAgeTF);
			addCustPanD.add(custAddExpLbl);
			addCustPanD.add(custAddExpQBtn);
			custAddExpQBtn.addActionListener(bh);
			addCustPanD.add(custAddExpDrop);
			addCustPanE.add(custAddPhoneLbl);
			addCustPanE.add(custAddPhoneQBtn);
			custAddPhoneQBtn.addActionListener(bh);
			addCustPanE.add(custAddPhoneTF);
			addCustPanF.add(custAddEmailLbl);
			addCustPanF.add(custAddEmailQBtn);
			custAddEmailQBtn.addActionListener(bh);
			addCustPanF.add(custAddEmailTF);
			
			addCustMenuBtnPan.add(subNewCustBtn);
			subNewCustBtn.addActionListener(bh);
			addCustMenuBtnPan.add(cancelNewCustBtn);
			cancelNewCustBtn.addActionListener(bh);
			
			//Edit Customer Card Construction

			editCustPan.setLayout(new GridLayout(7, 1));
			editCustPan.add(editCustPanA);
			editCustPan.add(editCustPanB);
			editCustPan.add(editCustPanC);
			editCustPan.add(editCustPanD);
			editCustPan.add(editCustPanE);
			editCustPan.add(editCustPanF);
			editCustPan.add(editCustMenuBtnPan);

			editCustPanA.add(custEditFNameLbl);
			editCustPanA.add(custEditFNameQBtn);
			custEditFNameQBtn.addActionListener(bh);
			editCustPanA.add(custEditFNameTF);
			editCustPanB.add(custEditLNameLbl);
			editCustPanB.add(custEditLNameQBtn);
			custEditLNameQBtn.addActionListener(bh);
			editCustPanB.add(custEditLNameTF);
			editCustPanC.add(custEditAgeLbl);
			editCustPanC.add(custEditAgeQBtn);
			custEditAgeQBtn.addActionListener(bh);
			editCustPanC.add(custEditAgeTF);
			editCustPanD.add(custEditExpLbl);
			editCustPanD.add(custEditExpQBtn);
			custEditExpQBtn.addActionListener(bh);
			editCustPanD.add(custEditExpDrop);
			editCustPanE.add(custEditPhoneLbl);
			editCustPanE.add(custEditPhoneQBtn);
			custEditPhoneQBtn.addActionListener(bh);
			editCustPanE.add(custEditPhoneTF);
			editCustPanF.add(custEditEmailLbl);
			editCustPanF.add(custEditEmailQBtn);
			custEditEmailQBtn.addActionListener(bh);
			editCustPanF.add(custEditEmailTF);
			
			editCustMenuBtnPan.add(subEditCustBtn);
			subEditCustBtn.addActionListener(bh);
			editCustMenuBtnPan.add(cancelEditCustBtn);
			cancelEditCustBtn.addActionListener(bh);
		
		// Travel Package Tab Construction
			
		packageTab.setLayout(new BorderLayout());
		packageTab.add(packInputPan, BorderLayout.NORTH);
		packInputPan.add(searchPackLbl, BorderLayout.WEST);
		packInputPan.add(searchPackTF, BorderLayout.CENTER);
		packInputPan.add(searchPackBtn, BorderLayout.EAST);
		packageTab.add(packDisplayPan, BorderLayout.CENTER);
		searchPackBtn.addActionListener(bh);
		db.packScroll.setBorder(new TitledBorder("List of Packages"));
		packDisplayPan.setLayout(new BorderLayout());
		packDisplayPan.add(db.packScroll, BorderLayout.CENTER);
		packDisplayPan.add(packNotice, BorderLayout.SOUTH);
		packageTab.add(packButtonsPan, BorderLayout.SOUTH);

		packButtonsPan.setLayout(new GridLayout(2,4));
		packButtonsPan.add(addPackBtn);
		addPackBtn.addActionListener(bh);
		packButtonsPan.add(editPackBtn);
		editPackBtn.addActionListener(bh);
		packButtonsPan.add(delPackBtn);
		delPackBtn.addActionListener(bh);
		packButtonsPan.add(clearSelPackBtn);
		clearSelPackBtn.addActionListener(bh);
		packButtonsPan.add(loadPackBtn);
		loadPackBtn.addActionListener(bh);
		packButtonsPan.add(savePackBtn);
		savePackBtn.addActionListener(bh);
		packButtonsPan.add(erasePackBtn);
		erasePackBtn.addActionListener(bh);
		packButtonsPan.add(closePackBtn);
		closePackBtn.addActionListener(bh);

			//Add Travel Package Card Construction

			addPackPan.setLayout(new GridLayout(7, 1));
			addPackPan.add(addPackPanA);
			addPackPan.add(addPackPanB);
			addPackPan.add(addPackPanC);
			addPackPan.add(addPackPanD);
			addPackPan.add(addPackPanE);
			addPackPan.add(addPackPanF);
			addPackPan.add(addPackMenuBtnPan);

			addPackPanA.setLayout(new GridLayout(1, 2, 10, 10));
			addPackPanA.add(packAddNameLbl);
			addPackPanA.add(packAddNameRLbl);
			addPackPanB.setLayout(new GridLayout(1, 2, 10, 10));
			addPackPanB.add(packAddAccomLbl);
			addPackPanB.add(packAddAccomRLbl);
			addPackPanC.add(packAddADateLbl);
			addPackPanC.add(packAddADateQBtn);
			packAddADateQBtn.addActionListener(bh);
			addPackPanC.add(packAddADateTF);
			addPackPanD.add(packAddDDateLbl);
			addPackPanD.add(packAddDDateQBtn);
			packAddDDateQBtn.addActionListener(bh);
			addPackPanD.add(packAddDDateTF);
			addPackPanE.add(packAddLessonsLbl);
			addPackPanE.add(packAddLessonsQBtn);
			packAddLessonsQBtn.addActionListener(bh);
			addPackPanE.add(packAddLessonsTF);
			addPackPanF.add(packAddLiftPassLbl);
			addPackPanF.add(packAddLiftPassQBtn);
			packAddLiftPassQBtn.addActionListener(bh);
			addPackPanF.add(packAddLiftPassDrop);
			
			addPackMenuBtnPan.add(subNewPackBtn);
			subNewPackBtn.addActionListener(bh);
			addPackMenuBtnPan.add(cancelNewPackBtn);
			cancelNewPackBtn.addActionListener(bh);
			
			//Edit Travel Package Card Construction

			editPackPan.setLayout(new GridLayout(7, 1));
			editPackPan.add(editPackPanA);
			editPackPan.add(editPackPanB);
			editPackPan.add(editPackPanC);
			editPackPan.add(editPackPanD);
			editPackPan.add(editPackPanE);
			editPackPan.add(editPackPanF);
			editPackPan.add(editPackMenuBtnPan);

			editPackPanA.setLayout(new GridLayout(1, 2, 10, 10));
			editPackPanA.add(packEditNameLbl);
			editPackPanA.add(packEditNameRLbl);
			editPackPanB.setLayout(new GridLayout(1, 2, 10, 10));
			editPackPanB.add(packEditAccomLbl);
			editPackPanB.add(packEditAccomRLbl);
			editPackPanC.add(packEditADateLbl);
			editPackPanC.add(packEditADateQBtn);
			packEditADateQBtn.addActionListener(bh);
			editPackPanC.add(packEditADateTF);
			editPackPanD.add(packEditDDateLbl);
			editPackPanD.add(packEditDDateQBtn);
			packEditDDateQBtn.addActionListener(bh);
			editPackPanD.add(packEditDDateTF);
			editPackPanE.add(packEditLessonsLbl);
			editPackPanE.add(packEditLessonsQBtn);
			packEditLessonsQBtn.addActionListener(bh);
			editPackPanE.add(packEditLessonsTF);
			editPackPanF.add(packEditLiftPassLbl);
			editPackPanF.add(packEditLiftPassQBtn);
			packEditLiftPassQBtn.addActionListener(bh);
			editPackPanF.add(packEditLiftPassDrop);
			
			editPackMenuBtnPan.add(subEditPackBtn);
			subEditPackBtn.addActionListener(bh);
			editPackMenuBtnPan.add(cancelEditPackBtn);
			cancelEditPackBtn.addActionListener(bh);

		// JFrame Setting
			
		program.add(mainPan);
		program.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        program.pack();
        program.setVisible(true);
        program.setSize(new Dimension(500, 500));
        program.setMinimumSize(new Dimension(400, 400));
        program.setLocationRelativeTo(null);
	}
	
	
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent act) {
			
			// Accommodation Button Actions

			if (act.getSource() == searchAccomBtn) {
				db.searchAccommodations(searchAccomTF.getText());
				System.out.println("Initiated: searching Accommodations");
			}
			if (act.getSource() == addAccomBtn) {
				cards.show(mainPan, "AA");
				System.out.println("Initiated: Accommodation ready for creation");
			}
			if (act.getSource() == editAccomBtn) {
				try {
					Accommodation a = db.accomList.getSelectedValue();
					accomEditNameTF.setText(a.getName());
					accomEditDescTF.setText(a.getDescription());
					accomEditTypeDrop.setSelectedItem(a.getType());
					accomEditCostTF.setText(Double.toString(a.getDailyCost()));
					accomEditMountCheck.setSelected(a.isOnMount());
					accomEditSnowCheck.setSelected(a.isSnow());
					accomEditKidsFreeCheck.setSelected(a.isKidsFree());
					accomEditInternetCheck.setSelected(a.isInternet());
					cards.show(mainPan, "EA");
					System.out.println("Initiated: Accommodation ready for editing");
				}
				catch(NullPointerException e) {
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "Please select an Accommodation to edit.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == delAccomBtn) {
				try {
					int a = db.accomList.getSelectedIndex();
					if(a !=-1){
						db.accomListModel.remove(a);
						db.arrayAccom.remove(a);
					}
					System.out.println("Success: Deleted Accommodation");
				}
				catch(NullPointerException e) {
					System.out.println("Error: null entry");
					JOptionPane.showMessageDialog(null, "Please select an Accommodation to delete.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == clearSelAccomBtn) {
				db.accomList.clearSelection();
			}
			if (act.getSource() == loadAccomBtn) {
				db.readAccommodations();
			}
			if (act.getSource() == saveAccomBtn) {
				db.saveAccommodations(true);
			}
			if (act.getSource() == eraseAccomBtn) {
				db.eraseAccommodationsFile();
			}
			
				// New & Edit Accommodation Button Actions
				
				if (act.getSource() == subNewAccomBtn) {
					try {
					    String name = accomAddNameTF.getText();
					    String desc = accomAddDescTF.getText();
					    ENUMaccomType type = (ENUMaccomType)accomAddTypeDrop.getSelectedItem();
					    double cost = Double.parseDouble(accomAddCostTF.getText());
					    boolean onMount = accomAddMountCheck.isSelected();
					    boolean snow = accomAddSnowCheck.isSelected();
					    boolean kidsFree = accomAddKidsFreeCheck.isSelected();
					    boolean internet = accomAddInternetCheck.isSelected();
					    Accommodation accommodation = new Accommodation(name, desc, type, cost, onMount, snow, kidsFree, internet);
					    db.arrayAccom.add(accommodation);
					    db.accomListModel.addElement(accommodation);
					    accomAddNameTF.setText("");
					    accomAddDescTF.setText("");
					    accomAddCostTF.setText("");
					    accomAddMountCheck.setSelected(false);
					    accomAddSnowCheck.setSelected(false);
					    accomAddKidsFreeCheck.setSelected(false);
					    accomAddInternetCheck.setSelected(false);
						cards.show(mainPan, "TB");
						System.out.println("Success: Accommodation created");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: number error");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: null entry");
						JOptionPane.showMessageDialog(null, "One or more sections are missing information, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == subEditAccomBtn) {
					try {
						Accommodation a = db.accomList.getSelectedValue();
					    a.setName(accomEditNameTF.getText());
					    a.setDescription(accomEditDescTF.getText());
					    a.setType((ENUMaccomType)accomEditTypeDrop.getSelectedItem());
					    a.setDailyCost(Double.parseDouble(accomEditCostTF.getText()));
					    a.setOnMount(accomEditMountCheck.isSelected());
					    a.setSnow(accomEditSnowCheck.isSelected());
					    a.setKidsFree(accomEditKidsFreeCheck.isSelected());
					    a.setInternet(accomEditInternetCheck.isSelected());
					    accomEditNameTF.setText("");
					    accomEditDescTF.setText("");
					    accomEditCostTF.setText("");
					    accomEditMountCheck.setSelected(false);
					    accomEditSnowCheck.setSelected(false);
					    accomEditKidsFreeCheck.setSelected(false);
					    accomEditInternetCheck.setSelected(false);
						cards.show(mainPan, "TB");
						System.out.println("Success: Accommodation edited");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: number error");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: null entry");
						JOptionPane.showMessageDialog(null, "One of the sections is incorrectly filled out, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == cancelNewAccomBtn || act.getSource() == cancelEditAccomBtn) {
				    accomAddNameTF.setText("");
				    accomAddDescTF.setText("");
				    accomAddCostTF.setText("");
				    accomAddMountCheck.setSelected(false);
				    accomAddSnowCheck.setSelected(false);
				    accomAddKidsFreeCheck.setSelected(false);
				    accomAddInternetCheck.setSelected(false);
				    accomEditNameTF.setText("");
				    accomEditDescTF.setText("");
				    accomEditCostTF.setText("");
				    accomEditMountCheck.setSelected(false);
				    accomEditSnowCheck.setSelected(false);
				    accomEditKidsFreeCheck.setSelected(false);
				    accomEditInternetCheck.setSelected(false);
					cards.show(mainPan, "TB");
					System.out.println("finished: Current action ended");
				}
				if (act.getSource() == accomAddNameQBtn || act.getSource() == accomEditNameQBtn) {
					JOptionPane.showMessageDialog(null, "Pleass enter the full name of the Accommodation.");
				}
				if (act.getSource() == accomAddDescQBtn || act.getSource() == accomEditDescQBtn) {
					JOptionPane.showMessageDialog(null, "Please give a brief description of the Accommodation.");
				}
				if (act.getSource() == accomAddTypeQBtn || act.getSource() == accomEditTypeQBtn) {
					JOptionPane.showMessageDialog(null, "Select what sort of Accommodation this is from the drop down menu.");
				}
				if (act.getSource() == accomAddCostQBtn || act.getSource() == accomEditCostQBtn) {
					JOptionPane.showMessageDialog(null, "How much does it cost to sty in this Accommodatio Per Night? (No not include a $ symbol and only include numbers to 2 decimal places) eg. 129.99");
				}
				if (act.getSource() == accomAddMountQBtn || act.getSource() == accomEditMountQBtn) {
					JOptionPane.showMessageDialog(null, "Check if the Accommodation is located on the Mountain.");
				}
				if (act.getSource() == accomAddSnowQBtn || act.getSource() == accomEditSnowQBtn) {
					JOptionPane.showMessageDialog(null, "Check if the Accommodation comes with a Snow Guarantee in winter.");
				}
				if (act.getSource() == accomAddKidsFreeQBtn || act.getSource() == accomEditKidsFreeQBtn) {
					JOptionPane.showMessageDialog(null, "Check if the Accommodation allows children to stay for free.");
				}
				if (act.getSource() == accomAddInternetQBtn || act.getSource() == accomEditInternetQBtn) {
					JOptionPane.showMessageDialog(null, "Check if the Accommodation has internet access.");
				}
			// Customer Button Actions

			if (act.getSource() == searchCustBtn) {
				System.out.println("Initiated: beginning search");
				db.searchCustomers(searchCustTF.getText());
			}
			
			if (act.getSource() == addCustBtn) {
				cards.show(mainPan, "AC");
				System.out.println("Initiated: Customer ready for creation");
			}
			if (act.getSource() == editCustBtn) {
				try {
					Customer a = db.custList.getSelectedValue();
					custEditFNameTF.setText(a.getFname());
					custEditLNameTF.setText(a.getLname());
					custEditAgeTF.setText(Byte.toString(a.getAge()));
					custEditExpDrop.setSelectedItem(a.getExperience());
					custEditPhoneTF.setText(a.getPhone());
					custEditEmailTF.setText(a.getEmail());
					cards.show(mainPan, "EC");
					System.out.println("Initiated: Customer ready for editing");
				}
				catch(NullPointerException e) {
					System.out.println("Error: Null entry");
					JOptionPane.showMessageDialog(null, "Please select a Customer to edit.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == delCustBtn) {
				try {
					int c = db.custList.getSelectedIndex();
					if(c !=-1){
						db.custListModel.remove(c);
						db.arrayCust.remove(c);
					}
					System.out.println("Success: Customer successfully deleted");
				}
				catch(NullPointerException e) {
					System.out.println("Error: null entry");
					JOptionPane.showMessageDialog(null, "Please select a Customer to delete.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == clearSelCustBtn) {
				db.custList.clearSelection();
			}
			if (act.getSource() == loadCustBtn) {
				db.readCustomers();
			}
			if (act.getSource() == saveCustBtn) {
				db.saveCustomers(true);
			}
			if (act.getSource() == eraseCustBtn) {
				db.eraseCustomersFile();
			}
			
				// New & Edit Customer Button Actions
				
				if (act.getSource() == subNewCustBtn) {
					try {
					    String fname = custAddFNameTF.getText();
					    String lname = custAddLNameTF.getText();
					    byte age = Byte.parseByte(custAddAgeTF.getText());
					    ENUMexperience exp = (ENUMexperience)custAddExpDrop.getSelectedItem();
					    String phone;
					    if(isNumeric(custAddPhoneTF.getText())) {
						    phone = custAddPhoneTF.getText();
					    }
					    else {
						    throw new NumberFormatException();
					    }
					    String email = custAddEmailTF.getText();
					    Customer customer = new Customer(fname, lname, age, exp, phone, email);
					    db.arrayCust.add(customer);
					    db.custListModel.addElement(customer);
					    custAddFNameTF.setText("");
					    custAddLNameTF.setText("");
					    custAddAgeTF.setText("");
					    custAddPhoneTF.setText("");
					    custAddEmailTF.setText("");
						cards.show(mainPan, "TB");
						System.out.println("Success: New Customer Created");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: number error");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: null entry");
						JOptionPane.showMessageDialog(null, "One or more sections are missing information, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == subEditCustBtn) {
					try {
						Customer c = db.custList.getSelectedValue();
					    c.setFname(custEditFNameTF.getText());
					    c.setLname(custEditLNameTF.getText());
					    c.setAge(Byte.parseByte(custEditAgeTF.getText()));
					    c.setExperience((ENUMexperience)custEditExpDrop.getSelectedItem());
					    if(isNumeric(custEditPhoneTF.getText())) {
						    c.setPhone(custEditPhoneTF.getText());
					    }
					    else {
						    throw new NumberFormatException();
					    }
					    c.setEmail(custEditEmailTF.getText());
					    custEditFNameTF.setText("");
					    custEditLNameTF.setText("");
					    custEditAgeTF.setText("");
					    custEditPhoneTF.setText("");
					    custEditEmailTF.setText("");
						cards.show(mainPan, "TB");
						System.out.println("Success: Customer details edited");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: Numerical Error.");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: null entry.");
						JOptionPane.showMessageDialog(null, "One of the sections is incorrectly filled out, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == cancelNewCustBtn || act.getSource() == cancelEditCustBtn) {
				    custAddFNameTF.setText("");
				    custAddLNameTF.setText("");
				    custAddAgeTF.setText("");
				    custAddPhoneTF.setText("");
				    custAddEmailTF.setText("");
				    custEditFNameTF.setText("");
				    custEditLNameTF.setText("");
				    custEditAgeTF.setText("");
				    custEditPhoneTF.setText("");
				    custEditEmailTF.setText("");
					cards.show(mainPan, "TB");
					System.out.println("Finish: ended current action.");
				}
				if (act.getSource() == custAddFNameQBtn || act.getSource() == custEditFNameQBtn) {
					JOptionPane.showMessageDialog(null, "Please state the first name of the customer.");
				}
				if (act.getSource() == custAddLNameQBtn || act.getSource() == custEditLNameQBtn) {
					JOptionPane.showMessageDialog(null, "Please state the last name of the customer.");
				}
				if (act.getSource() == custAddAgeQBtn || act.getSource() == custEditAgeQBtn) {
					JOptionPane.showMessageDialog(null, "Please specify the age of the customer.");
				}
				if (act.getSource() == custAddExpQBtn || act.getSource() == custEditExpQBtn) {
					JOptionPane.showMessageDialog(null, "Please select the level of skiing experience for the customer.");
				}
				if (act.getSource() == custAddPhoneQBtn || act.getSource() == custEditPhoneQBtn) {
					JOptionPane.showMessageDialog(null, "Please input a valid phone number. (numbers only)");
				}
				if (act.getSource() == custAddEmailQBtn || act.getSource() == custEditEmailQBtn) {
					JOptionPane.showMessageDialog(null, "Please input a valid Email address.");
				}
			
			// Travel Package Button Actions

			if (act.getSource() == searchPackBtn) {
				System.out.println("Initiated: Search for Travel Package.");
				db.searchTravelPackages(searchPackTF.getText());
			}
			if (act.getSource() == addPackBtn) {
				try {
					packAddNameRLbl.setText(db.custList.getSelectedValue().getFname());
					packAddAccomRLbl.setText(db.accomList.getSelectedValue().getName());
					cards.show(mainPan, "AP");
					System.out.println("Initiated: Travel Package ready for creation.");
				}
				catch(NullPointerException e) {
					System.out.println("Failed: no selected Travel Package.");
					JOptionPane.showMessageDialog(null, "Please select an Accommodation and Customer from the previous Tabs.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == editPackBtn) {
				try {
					packEditNameRLbl.setText(db.custList.getSelectedValue().getFname());
					packEditAccomRLbl.setText(db.accomList.getSelectedValue().getName());
					TravelPackage p = db.packList.getSelectedValue();
					DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-mm-dd");
					packEditADateTF.setText((p.getArrival()).format(time));
					packEditDDateTF.setText((p.getDeparture()).format(time));
					packEditLessonsTF.setText(Integer.toString(p.getLessons()));
					packEditLiftPassDrop.setSelectedItem(p.getLiftPass());
					cards.show(mainPan, "EP");
					JOptionPane.showMessageDialog(null, "Initiated: Travel Package ready for editing.");
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Failed: no selected Travel Package.");
					JOptionPane.showMessageDialog(null, "Please select a Travel Package to Edit.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == delPackBtn) {
				try {
					int p = db.packList.getSelectedIndex();
					TravelPackage pv = db.packList.getSelectedValue();
			       	Accommodation accom = pv.getAccommodation();
					if(p !=-1){
				       	accom.setAvailable(false);
						db.packListModel.remove(p);
						db.arrayPack.remove(p);
					}
					System.out.println("Success: Travel Package was deleted.");
				}
				catch(NullPointerException e) {
					System.out.println("Failed: no selected Travel Package.");
					JOptionPane.showMessageDialog(null, "Please select a Travel Package to Delete.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error: unknown");
					JOptionPane.showMessageDialog(null, "An unknown error occured.");
				}
			}
			if (act.getSource() == clearSelPackBtn) {
				db.packList.clearSelection();
			}
			if (act.getSource() == loadPackBtn) {
				db.readPackages();
			}
			if (act.getSource() == savePackBtn) {
				db.savePackages(true);
			}
			if (act.getSource() == erasePackBtn) {
				db.erasePackagesFile();
			}
				
				// New & Edit Travel Package Button Actions
				
				if (act.getSource() == subNewPackBtn) {
					try {
					    Customer cust = db.custList.getSelectedValue();
					    Accommodation accom = db.accomList.getSelectedValue();
					    LocalDate arrive;
					    LocalDate depart;
						LocalDate arrival = LocalDate.parse(packAddADateTF.getText());
						LocalDate departure = LocalDate.parse(packAddDDateTF.getText());
						if (departure.isAfter(arrival)) {
						    arrive = arrival;
						    depart = departure;
						}
						else {
							String blank = "";
							System.out.println("ERROR: Cannot have a departure date pre-dating the arrival date.");
							JOptionPane.showMessageDialog(null, "Your Departure date must be after your arrival date.");
							throw new DateTimeParseException(blank, blank, 0);
						}
					    int lessons = Integer.parseInt(packAddLessonsTF.getText());
					    ENUMliftPassValues liftPass = (ENUMliftPassValues)packAddLiftPassDrop.getSelectedItem();
					    TravelPackage travelPackage = new TravelPackage(cust, accom, arrive, depart, lessons, liftPass);
				       	accom.setAvailable(false);
					    db.arrayPack.add(travelPackage);
					    db.packListModel.addElement(travelPackage);
					    packAddADateTF.setText("");
					    packAddDDateTF.setText("");
					    packAddLessonsTF.setText("");
						cards.show(mainPan, "TB");
						System.out.println("Success: New Travel Package Created.");
					}
					catch(DateTimeParseException e) {
						System.out.println("Error: Incorrect date entry");
						JOptionPane.showMessageDialog(null, "Dates have been incorrectly formatted, please recheck their format and try again.");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: Incorrect number entry");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: void of entry");
						JOptionPane.showMessageDialog(null, "One of the sections is incorrectly filled out, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == subEditPackBtn) {
					try {
						TravelPackage p = db.packList.getSelectedValue();
						LocalDate arrive = LocalDate.parse(packEditADateTF.getText());
						LocalDate depart = LocalDate.parse(packEditDDateTF.getText());
						if (depart.isAfter(arrive)) {
						    p.setArrival(arrive);
						    p.setDeparture(depart);
						}
						else {
							String blank = "";
							System.out.println("Error: departure date predates arrival");
							JOptionPane.showMessageDialog(null, "Your Departure date must be after your arrival date.");
							throw new DateTimeParseException(blank, blank, 0);
						}
					    p.setLessons(Integer.parseInt(packEditLessonsTF.getText()));
					    p.setLiftPass((ENUMliftPassValues)packEditLiftPassDrop.getSelectedItem());
					    packEditADateTF.setText("");
					    packEditDDateTF.setText("");
					    packEditLessonsTF.setText("");
						cards.show(mainPan, "TB");
						System.out.println("Success: Travel Package Edited.");
					}
					catch(DateTimeParseException e) {
						System.out.println("Error: Incorrect date entry");
						JOptionPane.showMessageDialog(null, "Dates have been incorrectly formatted, please recheck their format and try again.");
					}
					catch(NumberFormatException e) {
						System.out.println("Error: Incorrect number entry");
						JOptionPane.showMessageDialog(null, "One or more sections are incorrectly filled out, please correct this error and try again.");
					}
					catch(NullPointerException e) {
						System.out.println("Error: void of entry");
						JOptionPane.showMessageDialog(null, "One of the sections is incorrectly filled out, please correct this error and try again.");
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error: unknown");
						JOptionPane.showMessageDialog(null, "An Unexpected Error occurred during creation");
					}
				}
				if (act.getSource() == cancelNewPackBtn || act.getSource() == cancelEditPackBtn) {
				    packAddADateTF.setText("");
				    packAddDDateTF.setText("");
				    packAddLessonsTF.setText("");
				    packEditADateTF.setText("");
				    packEditDDateTF.setText("");
				    packEditLessonsTF.setText("");
					cards.show(mainPan, "TB");
					System.out.println("Finish: ended current action.");
				}
				if (act.getSource() == packAddADateQBtn || act.getSource() == packEditADateQBtn) {
					JOptionPane.showMessageDialog(null, "Give a valid arrival date - Formatted YYYY-MM-DD, include any leading Zeros.");
				}
				if (act.getSource() == packAddDDateQBtn || act.getSource() == packEditDDateQBtn) {
					JOptionPane.showMessageDialog(null, "Give a valid departure date - Formatted YYYY-MM-DD, include any leading Zeros.");
				}
				if (act.getSource() == packAddLessonsQBtn || act.getSource() == packEditLessonsQBtn) {
					JOptionPane.showMessageDialog(null, "Specify the number of lessons the customer wishes to purchase.");
				}
				if (act.getSource() == packAddLiftPassQBtn || act.getSource() == packEditLiftPassQBtn) {
					JOptionPane.showMessageDialog(null, "Select a Lift Pass from the list, or none.");
				}
				if (act.getSource() == closeAccomBtn || act.getSource() == closeCustBtn || act.getSource() == closePackBtn) {
					db.saveAll();
					System.exit(1);
				}
		}
	}

	@SuppressWarnings("unused")
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	    	int n = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}