/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopfloor;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author NNAMDI
 */
public class Shopfloor extends javax.swing.JFrame   {
// Controller class for shop_floor application. It assembles everything.
    /**
     * @param args the command line arguments
     */
    // Initializations
    
    static  ResultSet rs;
    static String date;
    static String counter_name;
    static String qty_counted;
    static String officer_name;
    static String reason_for_count;
    static String reamage_from_audit_claimed;
    static String batch_number;
    static String print_type;
    static String denomination;
    static String count_number;
    static String production_supervisor;
    static JButton load;
    static JButton save;
    static JPanel panel;
    static boolean state;
    static material_security jk;
    static audit_screen ja;
    static internal_audit_screen internal_audit;
    static production_screen production;
    static store_handler store;
    static Insert hk;

    static String audit_personnel;
    static String waste_verified_removed;
    static String qty_to_counter;
    static String reamage_from_production_claimed;

    static String balanced;
    static String unbalanced = "Not needed";
    static Shopfloor kl;

    static String audit_staff;
    static String actual_qty;
    static String removed;
    static String reamage_from_msc_claimed;
    
    static String qty_reamage;
    static String waste_generated;
    static String head_minder ;
    
    static String store_staff;
    static String batch_qty;
                
  
   public Shopfloor(){
       // To use uncomment the required module.
       // msc_load();
       //audit_screen();
       //internal_audit_screen();
       //production_screen();
      store_handler_screen();
      
       
      panel = new JPanel();
   }
   
    public static void store_handler__frame(){kl.add(store, BorderLayout.CENTER);}
    
     public void store_handler_screen(){
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss"); Use this format later by increasing what the date
       //variable can accept. This is so that we can track storage time as well.
       
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dates = new Date();
               store = new store_handler();
                hk = new Insert();
                
                date = dateFormat.format(dates);  System.out.println(date);
                store.jLabel5.setText(date );
                
               
                
        load = new javax.swing.JButton("Loadedrssss");
        load.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load.setText("Load");
        load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        load.setVisible(false);
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println( ja.jTextField5.getText()+" Heeeyyyyyyyyyyyy Load");
               
            }
        });
        
       save = new javax.swing.JButton("Loadedrssss");
       save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                 store_staff= store.jTextField1.getText();
                 
                System.out.println(audit_staff+" Heeeyyyyyyyyyyyy Save");
                System.out.println( store.jTextField1.getText());
                
                batch_qty = store.jTextField3.getText()+"/"+store.jTextField4.getText();
                batch_number = store.jTextField2.getText();
                print_type = store.jComboBox5.getSelectedItem().toString();
                denomination= store.jComboBox6.getSelectedItem().toString();
               
               
                
              
                state = hk.insert_store_handler(date, batch_number , "Store", store_staff, denomination, batch_qty);
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Message inserted successfully", "Message Insertion", 1);
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to insert, contact IT personnel", "Message Insertion", 1);
                
                }
               
               
                
               
            }
        });
   } 
   

    public static void production_screen_load_frame(){kl.add(production, BorderLayout.CENTER);}
    
    public void production_screen(){
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss"); Use this format later by increasing what the date
       //variable can accept. This is so that we can track storage time as well.
       
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dates = new Date();
                production = new production_screen();
                hk = new Insert();
                
                date = dateFormat.format(dates);  System.out.println(date);
                production.jLabel12.setText(date );
                production.jComboBox4.removeAllItems();
                
                
        load = new javax.swing.JButton("Loadedrssss");
        load.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load.setText("Load ");
        load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println( ja.jTextField5.getText()+" Heeeyyyyyyyyyyyy Load");
                    
               
                rs = hk.retrieve_batch_number();
                
                try{
                    production.jComboBox4.removeAllItems();
                   
        
                while(rs.next()){
                    
                    production.jComboBox4.addItem(rs.getString("batch_number"));
                }
               
                
                state = true;
                
                } catch(Exception e){
                System.err.println("Got an exception from shop floor");
                System.err.println(e.getMessage());
                
                }
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Batch Number loaded successfully", "Message Insertion", 1);
                     
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to load , contact IT personnel", "Message Insertion", 1);
                
                }
                
                
            }
        });
        
       save = new javax.swing.JButton("Loadedrssss");
       save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                 qty_reamage= production.jTextField1.getText()+"/"+production.jTextField2.getText();;
                 
                System.out.println(audit_staff+" Heeeyyyyyyyyyyyy Save");
                System.out.println( production.jTextField1.getText());
                
                waste_generated = production.jTextField3.getText()+"/"+production.jTextField4.getText();
                head_minder = production.jTextField5.getText();
                production_supervisor=  production.jTextField6.getText();
               
                
                batch_number = production.jComboBox4.getSelectedItem().toString();
                print_type = production.jComboBox5.getSelectedItem().toString();
                denomination= production.jComboBox6.getSelectedItem().toString();
               
               
                
              
                state = hk.insert_production_screen(batch_number, qty_reamage, waste_generated, head_minder, 
                        production_supervisor, print_type, denomination, date);
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Message inserted successfully", "Message Insertion", 1);
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to insert, contact IT personnel", "Message Insertion", 1);
                
                }
               
               
                
               
            }
        });
   } 
    
    public static void internal_audit_screen_load_frame(){kl.add(internal_audit, BorderLayout.CENTER);}
    
    // For internal_audit
    
       public void internal_audit_screen(){
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss"); Use this format later by increasing what the date
       //variable can accept. This is so that we can track storage time as well.
       
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dates = new Date();
                internal_audit = new internal_audit_screen();
                hk = new Insert();
                
                date = dateFormat.format(dates);  System.out.println(date);
                internal_audit.jLabel8.setText(date );
                internal_audit.jComboBox4.removeAllItems();
               
                
        load = new javax.swing.JButton("Loadedrssss");
        load.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load.setText("Load");
        load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println( ja.jTextField5.getText()+" Heeeyyyyyyyyyyyy Load");
                    
               
                rs = hk.retrieve_batch_number();
                
                try{
                    internal_audit.jComboBox4.removeAllItems();
                   
        
                while(rs.next()){
                    
                    internal_audit.jComboBox4.addItem(rs.getString("batch_number"));
                }
                state = true;
                
                } catch(Exception e){
                System.err.println("Got an exception from shop floor");
                System.err.println(e.getMessage());
                
                }
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Batch Number loaded successfully", "Message Insertion", 1);
                     
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to load , contact IT personnel", "Message Insertion", 1);
                
                }
                
                
            }
        });
        
       save = new javax.swing.JButton("Loadedrssss");
       save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                 audit_staff= internal_audit.jTextField1.getText();
                 
                System.out.println(audit_staff+" Heeeyyyyyyyyyyyy Save");
                System.out.println( internal_audit.jTextField1.getText());
                
                actual_qty = internal_audit.jTextField3.getText()+"/"+internal_audit.jTextField4.getText();
                removed = internal_audit.jTextField5.getText()+"/"+internal_audit.jTextField2.getText();
                reason_for_count= internal_audit.jTextArea1.getText();
               
                
                batch_number = internal_audit.jComboBox4.getSelectedItem().toString();
                print_type = internal_audit.jComboBox5.getSelectedItem().toString();
                denomination= internal_audit.jComboBox7.getSelectedItem().toString();
                count_number = internal_audit.jComboBox6.getSelectedItem().toString();
                reamage_from_msc_claimed = internal_audit.jTextField8.getText();
               
                
              
                state = hk.insert_internal_audit_second(date, audit_staff, actual_qty, removed, reason_for_count,
                        batch_number, print_type, denomination, count_number, reamage_from_msc_claimed);
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Message inserted successfully", "Message Insertion", 1);
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to insert, contact IT personnel", "Message Insertion", 1);
                
                }
               
               
                
               
            }
        });
   } 
   
    // End of internal audit
    
       // To load audit_screen frame
   public static void audit_screen_load_frame(){kl.add(ja, BorderLayout.CENTER);}
   
   public void audit_screen(){
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss"); Use this format later by increasing what the date
       //variable can accept. This is so that we can track storage time as well.
       
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dates = new Date();
                ja = new audit_screen();
                hk = new Insert();
                
                date = dateFormat.format(dates);  System.out.println(date);
                ja.jLabel13.setText(date );
                ja.jComboBox4.removeAllItems();
               
                
   load = new javax.swing.JButton("Loadedrssss");
       load.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load.setText("Load");
        load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println( ja.jTextField5.getText()+" Heeeyyyyyyyyyyyy Load");
                    
               
                rs = hk.retrieve_batch_number();
                
                try{
                   ja.jComboBox4.removeAllItems();
                   
        
                while(rs.next()){
                    
                    ja.jComboBox4.addItem(rs.getString("batch_number"));
                }
                state = true;
                
                } catch(Exception e){
                System.err.println("Got an exception from shop floor");
                System.err.println(e.getMessage());
                
                }
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Batch Number loaded successfully", "Message Insertion", 1);
                     
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to load , contact IT personnel", "Message Insertion", 1);
                
                }
                
                
            }
        });
        
        save = new javax.swing.JButton("Loadedrssss");
       save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println(audit_personnel+" Heeeyyyyyyyyyyyy Save");
                 audit_personnel = ja.jTextField5.getText();
                
                System.out.println( ja.jTextField5.getText());
                
                waste_verified_removed = ja.jTextField1.getText()+"/"+ja.jTextField2.getText();
                qty_to_counter = ja.jTextField3.getText()+"/"+ja.jTextField4.getText();
                reamage_from_production_claimed = ja.jTextField6.getText();
                batch_number = ja.jComboBox4.getSelectedItem().toString();
                
                count_number = ja.jComboBox6.getSelectedItem().toString();
                reason_for_count = ja.jTextArea1.getText();
                print_type= ja.jComboBox5.getSelectedItem().toString();
                denomination = ja.jComboBox2.getSelectedItem().toString();
                balanced = ja.jComboBox1.getSelectedItem().toString();
                unbalanced = "Not needed";
                
                hk.insert_internal_audit_first( date,  audit_personnel, waste_verified_removed,
             qty_to_counter,reamage_from_production_claimed,  batch_number,
             count_number, reason_for_count, print_type,
             denomination, balanced, unbalanced);
            }
        });
   } //End of audit_screen()
   
   
   // To load msc frame
    public static void msc_load_frame(){kl.add(jk, BorderLayout.CENTER);}
    
    
   // To load msc jPanel
   public void msc_load(){
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss"); Use this format later by increasing what the date
       //variable can accept. This is so that we can track storage time as well.
       
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dates = new Date();
                jk = new material_security();
                hk = new Insert();
                
                date = dateFormat.format(dates);  System.out.println(date);
                jk.jLabel13.setText(date );
                jk.jComboBox4.removeAllItems();
                
                
   load = new javax.swing.JButton("Loadedrssss");
       load.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        load.setText("Load");
        load.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println( ja.jTextField5.getText()+" Heeeyyyyyyyyyyyy Load");
                    
               
                rs = hk.retrieve_batch_number();
                
                try{
                    jk.jComboBox4.removeAllItems();
                   
        
                while(rs.next()){
                    
                    jk.jComboBox4.addItem(rs.getString("batch_number"));
                }
                state = true;
                
                } catch(Exception e){
                System.err.println("Got an exception from shop floor");
                System.err.println(e.getMessage());
                
                }
                if (state == true){ 
                    JOptionPane.showMessageDialog(rootPane, "Batch Number loaded successfully", "Message Insertion", 1);
                     
                }
                else{ JOptionPane.showMessageDialog(rootPane, "Failed to load , contact IT personnel", "Message Insertion", 1);
                
                }
                
                
            }
        });
        
        save = new javax.swing.JButton("Loadedrssss");
       save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println(jk.jTextField1.getText()+" Heeeyyyyyyyyyyyy Save");
                 hk.insert_msc(date, jk.jTextField1.getText(), jk.jTextField3.getText()+"n/"+jk.jTextField4.getText(), jk.jTextField5.getText(), jk.jTextArea1.getText(), jk.jTextField8.getText(),
                        jk.jComboBox4.getSelectedItem().toString(),jk.jComboBox5.getSelectedItem().toString(), jk.jComboBox7.getSelectedItem().toString(), jk.jComboBox6.getSelectedItem().toString(), jk.jTextField6.getText());
            }
        });
   }
   //End of msc
   
   
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        
     kl = new Shopfloor();
       // To use uncomment the required load_frame method. It must correspond 
       // with the one uncommented in Shopfloor() constructor.
               
                // msc_load_frame();
                //audit_screen_load_frame();
                //internal_audit_screen_load_frame();
                //production_screen_load_frame();
                store_handler__frame();
                
                panel.add(load);
                panel.add(save);
                kl.add(panel, BorderLayout.SOUTH);
                
                
                kl.setSize(960,455);
                //kl.setResizable(false);
                kl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                kl.setVisible(true);
                
                
                
               
                
    }
    
}
