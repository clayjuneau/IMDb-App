//package prcprojectGUI;
import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface
import java.sql.*;
import java.awt.BorderLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.io.File;  
import java.io.FileWriter;  
/**
   The KiloConverterWindow class displays a JFrame that
   lets the user enter a distance in kilometers. When
   the Calculate button is clicked, a dialog box is
   displayed with the distance converted to miles.
*/

public class PRCprojectGUI extends JFrame
{
   private JLabel messageLabel;      // To reference a label
   private JTextField nameTextField; // To reference a text field
   private JButton calcButton;       // To reference a button
   private JComboBox searchForComboBox;

   private final int WINDOW_WIDTH = 1000;  // Window width
   private final int WINDOW_HEIGHT = 600; // Window height
   private JPanel panel_1;
   private JLabel lblMakeYourSelection;
   private JRadioButton writeTo;
   private JRadioButton outputTo;
   private JCheckBox chckbxActor;
   private JCheckBox chckbxDirector;
   private JCheckBox chckbxWriter;
   private JCheckBox chckbxYearOfRelease;
   private JCheckBox chckbxTitles;
   private JRadioButton radioAnd;
   private JRadioButton radioOr;
   private JRadioButton radioNot;
   private JLabel lblifEneteringMultiple;
   private JTabbedPane tabbedPane;
   private JPanel panel;
   private JPanel panel_2;
   private JPanel panel_3;
   private JPanel main_panel;
   private JTextField search1;
   private JTextField search2;
   private JTextField answer_special;
   private JRadioButton phase4Q1_1;
   private JRadioButton phase4Q2_1;
   private JRadioButton phase4Q3_1;

   /**
      Constructor
   */

   public PRCprojectGUI()
   {
      // Set the window title.
      setTitle("Database Search");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the panel and add it to the frame.
      buildPanel();
      
      radioOr = new JRadioButton("Or");
      radioOr.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) 
      	{
      		radioAnd.setSelected(false);
      		radioNot.setSelected(false);
      	}
      });
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      GroupLayout groupLayout = new GroupLayout(getContentPane());
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addContainerGap()
      			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 992, GroupLayout.PREFERRED_SIZE)
      			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addContainerGap()
      			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
      			.addContainerGap(19, Short.MAX_VALUE))
      );
      
      panel_2 = new JPanel();
      tabbedPane.addTab("Database Search", null, panel_2, null);
      
      panel_1 = new JPanel();
      
      lblMakeYourSelection = new JLabel("Make Your Selection:");
      panel_1.add(lblMakeYourSelection);
      
      chckbxActor = new JCheckBox("Actor");
      panel_1.add(chckbxActor);
      
       chckbxDirector = new JCheckBox("Director");
       panel_1.add(chckbxDirector);
       
        chckbxWriter = new JCheckBox("Writer");
        panel_1.add(chckbxWriter);
        
         chckbxYearOfRelease = new JCheckBox("Year of Release");
         panel_1.add(chckbxYearOfRelease);
         
          chckbxTitles = new JCheckBox("Titles");
          panel_1.add(chckbxTitles);
      
      panel = new JPanel();
      
      outputTo = new JRadioButton("Output to Screen");
      outputTo.setSelected(true);
      
      writeTo = new JRadioButton("Write to a File");
      
      JLabel lblOutput = new JLabel("Output:");
      // Create a label to display instructions.
      messageLabel = new JLabel("Enter the name: ");
      
            // Create a text field 10 characters wide.
            nameTextField = new JTextField(40);
            
            lblifEneteringMultiple = new JLabel("(If enetering multiple selections, seperate by comma.)");
            
            radioNot = new JRadioButton("Not");
            
            radioAnd = new JRadioButton("And");
            
                  // Create a button with the caption "Calculate".
                  calcButton = new JButton("Search");
                  GroupLayout gl_panel_2 = new GroupLayout(panel_2);
                  gl_panel_2.setHorizontalGroup(
                  	gl_panel_2.createParallelGroup(Alignment.LEADING)
                  		.addGroup(gl_panel_2.createSequentialGroup()
                  			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                  				.addGroup(gl_panel_2.createSequentialGroup()
                  					.addGap(194)
                  					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                  				.addGroup(gl_panel_2.createSequentialGroup()
                  					.addContainerGap()
                  					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 945, GroupLayout.PREFERRED_SIZE)))
                  			.addContainerGap(20, Short.MAX_VALUE))
                  );
                  gl_panel_2.setVerticalGroup(
                  	gl_panel_2.createParallelGroup(Alignment.LEADING)
                  		.addGroup(gl_panel_2.createSequentialGroup()
                  			.addContainerGap()
                  			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  			.addGap(87)
                  			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                  			.addGap(101))
                  );
                  GroupLayout gl_panel = new GroupLayout(panel);
                  gl_panel.setHorizontalGroup(
                  	gl_panel.createParallelGroup(Alignment.LEADING)
                  		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                  			.addContainerGap(333, Short.MAX_VALUE)
                  			.addComponent(lblifEneteringMultiple)
                  			.addGap(274))
                  		.addGroup(gl_panel.createSequentialGroup()
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  					.addGroup(gl_panel.createSequentialGroup()
                  						.addContainerGap()
                  						.addComponent(writeTo)
                  						.addGap(73))
                  					.addGroup(gl_panel.createSequentialGroup()
                  						.addContainerGap()
                  						.addComponent(lblOutput)))
                  				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  					.addGroup(gl_panel.createSequentialGroup()
                  						.addContainerGap()
                  						.addComponent(outputTo))
                  					.addGroup(gl_panel.createSequentialGroup()
                  						.addGap(139)
                  						.addComponent(messageLabel)
                  						.addPreferredGap(ComponentPlacement.RELATED)
                  						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  						.addPreferredGap(ComponentPlacement.RELATED)
                  						.addComponent(calcButton))))
                  			.addPreferredGap(ComponentPlacement.RELATED, 651, Short.MAX_VALUE)
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  				.addComponent(radioAnd)
                  				.addComponent(radioNot))
                  			.addGap(40))
                  );
                  gl_panel.setVerticalGroup(
                  	gl_panel.createParallelGroup(Alignment.LEADING)
                  		.addGroup(gl_panel.createSequentialGroup()
                  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  				.addGroup(gl_panel.createSequentialGroup()
                  					.addContainerGap(30, Short.MAX_VALUE)
                  					.addComponent(lblOutput)
                  					.addPreferredGap(ComponentPlacement.RELATED)
                  					.addComponent(writeTo)
                  					.addPreferredGap(ComponentPlacement.RELATED)
                  					.addComponent(outputTo)
                  					.addGap(35)
                  					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                  						.addComponent(messageLabel)
                  						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  						.addComponent(calcButton))
                  					.addPreferredGap(ComponentPlacement.RELATED)
                  					.addComponent(lblifEneteringMultiple))
                  				.addGroup(gl_panel.createSequentialGroup()
                  					.addGap(39)
                  					.addComponent(radioAnd)
                  					.addPreferredGap(ComponentPlacement.RELATED)
                  					.addComponent(radioNot)))
                  			.addContainerGap(93, Short.MAX_VALUE))
                  );
                  panel.setLayout(gl_panel);
                  panel_2.setLayout(gl_panel_2);
                  
                  panel_3 = new JPanel();
                  tabbedPane.addTab("Special Scenarios", null, panel_3, null);
                  
                 phase4Q1_1 = new JRadioButton("Give 2 actors, List the shortest list of movie titles that connects the 2. ");
                  phase4Q2_1 = new JRadioButton("Given 2 years, be able to list the shortest list of (Directors, or Actors) that had movies released.");
                  phase4Q3_1 = new JRadioButton("Given a actor, list the first movie they were in.");
                  main_panel = new JPanel();
                  main_panel.setVisible(false);
                  
                 
                   
                             
                   GroupLayout gl_panel_3 = new GroupLayout(panel_3);
                   gl_panel_3.setHorizontalGroup(
                   	gl_panel_3.createParallelGroup(Alignment.TRAILING)
                   		.addGroup(gl_panel_3.createSequentialGroup()
                   			.addContainerGap(155, Short.MAX_VALUE)
                   			.addComponent(main_panel, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
                   			.addGap(115))
                   		.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
                   			.addGap(246)
                   			.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                   				.addComponent(phase4Q3_1)
                   				.addComponent(phase4Q2_1)
                   				.addComponent(phase4Q1_1))
                   			.addContainerGap(93, Short.MAX_VALUE))
                   );
                   gl_panel_3.setVerticalGroup(
                   	gl_panel_3.createParallelGroup(Alignment.LEADING)
                   		.addGroup(gl_panel_3.createSequentialGroup()
                   			.addContainerGap()
                   			.addComponent(phase4Q1_1)
                   			.addGap(5)
                   			.addComponent(phase4Q2_1)
                   			.addPreferredGap(ComponentPlacement.RELATED)
                   			.addComponent(phase4Q3_1)
                   			.addGap(84)
                   			.addComponent(main_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                   			.addContainerGap(61, Short.MAX_VALUE))
                   );
                   
                   search1 = new JTextField();
                   search1.setColumns(10);
                   
                   search2 = new JTextField();
                   search2.setColumns(10);
                   
                   JButton search_button = new JButton("Search");
                   search_button.addActionListener(new SearchButtonListener());
                   
                   answer_special = new JTextField();
                   answer_special.setColumns(10);
                   
                   JLabel search1_label = new JLabel("Actor 1:");
                   
                   JLabel search2_label = new JLabel("Actor 2:");
                   
                   JLabel answer_label = new JLabel("Result:");
                   
                   
                   
                   
                   GroupLayout gl_main_panel = new GroupLayout(main_panel);
                   gl_main_panel.setHorizontalGroup(
                   	gl_main_panel.createParallelGroup(Alignment.LEADING)
                   		.addGroup(gl_main_panel.createSequentialGroup()
                   			.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
                   				.addGroup(gl_main_panel.createSequentialGroup()
                   					.addGap(282)
                   					.addComponent(search_button))
                   				.addGroup(gl_main_panel.createSequentialGroup()
                   					.addGap(137)
                   					.addGroup(gl_main_panel.createParallelGroup(Alignment.TRAILING)
                   						.addGroup(gl_main_panel.createSequentialGroup()
                   							.addComponent(search2_label)
                   							.addPreferredGap(ComponentPlacement.RELATED)
                   							.addComponent(search2, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                   						.addGroup(gl_main_panel.createSequentialGroup()
                   							.addComponent(search1_label)
                   							.addPreferredGap(ComponentPlacement.RELATED)
                   							.addComponent(search1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))))
                   				.addGroup(gl_main_panel.createSequentialGroup()
                   					.addGap(31)
                   					.addComponent(answer_label)
                   					.addPreferredGap(ComponentPlacement.RELATED)
                   					.addComponent(answer_special, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)))
                   			.addContainerGap(157, Short.MAX_VALUE))
                   );
                   gl_main_panel.setVerticalGroup(
                   	gl_main_panel.createParallelGroup(Alignment.LEADING)
                   		.addGroup(gl_main_panel.createSequentialGroup()
                   			.addGap(65)
                   			.addGroup(gl_main_panel.createParallelGroup(Alignment.BASELINE)
                   				.addComponent(search1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                   				.addComponent(search1_label))
                   			.addGap(18)
                   			.addGroup(gl_main_panel.createParallelGroup(Alignment.BASELINE)
                   				.addComponent(search2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                   				.addComponent(search2_label))
                   			.addGap(28)
                   			.addComponent(search_button)
                   			.addPreferredGap(ComponentPlacement.UNRELATED)
                   			.addGroup(gl_main_panel.createParallelGroup(Alignment.BASELINE)
                   				.addComponent(answer_special, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                   				.addComponent(answer_label))
                   			.addContainerGap(40, Short.MAX_VALUE))
                   );
                   main_panel.setLayout(gl_main_panel);
                   panel_3.setLayout(gl_panel_3);
                   
                   phase4Q1_1.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		if(phase4Q1_1.isSelected())
                    		phase4Q2_1.setSelected(false);
                    		phase4Q3_1.setSelected(false);
                    		main_panel.setVisible(true);
                    		search2_label.setVisible(true);
                    		search2.setVisible(true);
                    		search1_label.setText("Actor 1:");
                    		search2_label.setText("Actor 2:");
                    		
                    	}
                    });
                  phase4Q2_1.addActionListener(new ActionListener() {
                  	public void actionPerformed(ActionEvent e) {
                  		if(phase4Q2_1.isSelected())
                  		phase4Q1_1.setSelected(false);
                  		phase4Q3_1.setSelected(false);
                		main_panel.setVisible(true);
                		search2_label.setVisible(true);
                		search2.setVisible(true);
                		search1_label.setText("First Year:");
                		search2_label.setText("Second Year:");

                  	}
                  });
                  phase4Q3_1.addActionListener(new ActionListener() {
                  	public void actionPerformed(ActionEvent e) {
                  		if(phase4Q3_1.isSelected())
                  		phase4Q1_1.setSelected(false);
                  		phase4Q2_1.setSelected(false);
                		main_panel.setVisible(true);
                		search2_label.setVisible(false);
                		search2.setVisible(false);
                		

                  	}
                  });
                  
                        // Add an action listener to the button.
                        calcButton.addActionListener(new CalcButtonListener());
            radioAnd.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if(radioAnd.isSelected())
            		{
            			radioOr.setSelected(false);
            			radioNot.setSelected(false);
            		}
            	}
            });
            radioNot.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		radioOr.setSelected(false);
            		radioAnd.setSelected(false);
            	}
            });
      writeTo.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(writeTo.isSelected())
      		{
      			outputTo.setSelected(false);
      		}
      	}
      });
      outputTo.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(outputTo.isSelected())
      		{
      			writeTo.setSelected(false);
      		}
      	}
      });
      getContentPane().setLayout(groupLayout);

      // Display the window.
      setVisible(true);
   }

   /**
      The buildPanel method adds a label, text field, and
      and a button to a panel.
   */

   private void buildPanel()
   {
   }

   private class CalcButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executes when the user
         clicks on the Calculate button.
         @param e The event object.
      */

      public void actionPerformed(ActionEvent e)
      {
         dbSetup my = new dbSetup();
         //Building the connection
         Connection conn = null;
         try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://db-315.cse.tamu.edu/PRCproject",
               my.user, my.pswd);
         } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            System.exit(0);
         }//end try catch
         JOptionPane.showMessageDialog(null,"Opened database successfully");
         String resultTable = "";
         try{
            //create a statement object
            Statement stmt = conn.createStatement();

            String fromTXT = "";
            String whereTXT = "";
            Boolean person = false;
            Boolean movie = false;
            if(chckbxActor.isSelected() || chckbxDirector.isSelected() || chckbxWriter.isSelected()){
               fromTXT = "name_basics";
               whereTXT = "primaryName";
               person = true;
            }
            else if(chckbxYearOfRelease.isSelected() || chckbxTitles.isSelected()){
               fromTXT = "title_basics";
               whereTXT = "primaryTitle";
               movie = true;
            }

            String name = nameTextField.getText();
            String names[] = name.split(", ");

            //System.out.println("names0: " + names[0] + " names1: " + names[1] + "\n");
            //System.out.println(names + "\n");
            String sqlStatement;

            if(names.length>1){
               if(radioNot.isSelected()) //not with 2 things
                  sqlStatement = "SELECT * FROM " + fromTXT + " where " + whereTXT + " NOT IN ('" + names[0] + "', '" + names[1] + "')";
               else //OR with 2 things
                  sqlStatement = "SELECT * FROM " + fromTXT + " where " + whereTXT + "=" + "'" + names[0] + "'" + " OR " + whereTXT + "=" + "'" + names[1] + "'" ;
            }
            else{
               if(radioNot.isSelected()) //not with one thing
                  sqlStatement = "SELECT * FROM " + fromTXT + " where " + whereTXT + " NOT IN ('" + name + "')";
               else //OR with one thing
                  sqlStatement = "SELECT * FROM " + fromTXT + " where " + whereTXT + "=" + "'" + name + "'";
            }
           System.out.println(sqlStatement);
         
            //send statement to DBMS
            ResultSet result = stmt.executeQuery(sqlStatement);

            while (result.next()) {
               if(person){
                  resultTable += result.getString("primaryName")+"\n";
                  resultTable += "Birth Year: ";
                  resultTable += result.getString("birthYear")+"\n";
                  resultTable += "Death Year: ";
                  resultTable += result.getString("deathYear")+"\n";
                  resultTable += "Known for: ";
                  resultTable += result.getString("knownForTitles")+"\n";
                  resultTable += "Primary professions: ";
                  resultTable += result.getString("primaryProfession")+"\n";
                  resultTable += "\n";
               }
               if(movie){
                  resultTable += result.getString("primaryTitle")+"\n";
                  resultTable += "Start Year: ";
                  resultTable += result.getString("startYear")+"\n";
                  resultTable += "End Year: ";
                  resultTable += result.getString("endYear")+"\n";
                  resultTable += "Runtime (minutes): ";
                  resultTable += result.getString("runtimeMinutes")+"\n";
                  resultTable += "Genres: ";
                  resultTable += result.getString("genres")+"\n";
                  resultTable += "\n";
               }
            }
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"Error accessing Database.");
         }
         //output on screen
         if(outputTo.isSelected())
            JOptionPane.showMessageDialog(null,resultTable);
         
         //output to file
         if(writeTo.isSelected()){
            try{    
            FileWriter fw=new FileWriter("output.txt");    
            fw.write(resultTable);    
            fw.close();    
            }catch(Exception p){System.out.println(p);}    
            System.out.println("Success...");   
            JOptionPane.showMessageDialog(null,"Output to file output.txt");
         }
            


         //closing the connection
         try {
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection Closed.");
         } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
         }//end try catch

         // For debugging, display a message indicating
         // the application is ready for more input.
         System.out.println("Ready for the next input.");
      }
   } // End of CalcButtonListener class
   
   // PHASE 4 NEW TAB BUTTON

   private class SearchButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executes when the user
         clicks on the Calculate button.
         @param e The event object.
      */

      public void actionPerformed(ActionEvent e)
      {
         dbSetup my = new dbSetup();
         //Building the connection
         Connection conn = null;
         try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://db-315.cse.tamu.edu/PRCproject",
               my.user, my.pswd);
         } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
            System.exit(0);
         }//end try catch
         //JOptionPane.showMessageDialog(null,"Opened database successfully");
         String resultTable = "";
         String sqlStatement;
         Boolean q3 = false;
         Boolean q2 = false;
         Boolean q1 = false;
         try{
            //create a statement object
            Statement stmt = conn.createStatement();
            
            // QUESTION 3
            if(phase4Q3_1.isSelected()){
               q3 = true;
               String query1 = "select knownfortitles from name_basics where primaryname = '" + search1.getText() + "'";

               System.out.println("query1: " + query1);

               ResultSet query1ResultSet = stmt.executeQuery(query1);
               String tconstList = "";
               while(query1ResultSet.next()){
                  // System.out.println("HERE");
                  System.out.println("this: " + query1ResultSet.getString("knownForTitles"));
                  tconstList = query1ResultSet.getString("knownForTitles");
               }
               String tconstListArr[] = tconstList.split(",");

               System.out.println("tconstListArr: " + tconstListArr[0]);

               sqlStatement = "select primarytitle from title_basics where (tconst = '";

               for(int i = 0; i<tconstListArr.length; i++){
                  sqlStatement += tconstListArr[i];

                  if(i != tconstListArr.length-1)
                  sqlStatement += "' OR tconst = '";
               }

               sqlStatement += "') order by startyear ASC limit 1";

            }
            
            // //QUESTION 1
            // else if(phase4Q1_1.isSelected()){

            // }
            // //QUESTION 2
            // else if(phase4Q2_1.isSelected()){

            // }
            else{
               sqlStatement = "";
            }
            System.out.println("RIGHT HERE");

            

            
            System.out.println(sqlStatement);
         
            //send statement to DBMS
            ResultSet result = stmt.executeQuery(sqlStatement);

            while (result.next()) {
               if(q3){
                  resultTable += result.getString("primaryTitle");
               }
            }
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"Error accessing Database.");
         }
         //output on screen
         
            //JOptionPane.showMessageDialog(null,resultTable);
            answer_special.setText(resultTable);
         
         //closing the connection
         try {
            conn.close();
            //JOptionPane.showMessageDialog(null,"Connection Closed.");
         } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
         }//end try catch

         // For debugging, display a message indicating
         // the application is ready for more input.
         System.out.println("Ready for the next input.");
      }
   } // End of searchbuttonlistener class


   public static void main(String[] args)
   {
      new PRCprojectGUI();
   }
}