/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp;

import static ChatApp.client.dis;
import static ChatApp.client.dos;
import static ChatApp.client.ff;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author bhupendraprajapati
 */
public class server extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dos;
    static String ff="";
    static FileInputStream fis;
   // static FileOutputSream fos;
    /**
     * Creates new form calculator
     */
    public server() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jFileChooser2 = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_area_s = new javax.swing.JTextArea();
        msg_text_s = new javax.swing.JTextField();
        send_btn_s = new javax.swing.JButton();
        Name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area_s.setColumns(20);
        msg_area_s.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        msg_area_s.setForeground(new java.awt.Color(3, 0, 255));
        msg_area_s.setRows(5);
        jScrollPane2.setViewportView(msg_area_s);

        msg_text_s.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        msg_text_s.setForeground(new java.awt.Color(0, 255, 192));
        msg_text_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_text_sActionPerformed(evt);
            }
        });

        send_btn_s.setBackground(new java.awt.Color(0, 255, 25));
        send_btn_s.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        send_btn_s.setText("Send");
        send_btn_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_btn_sActionPerformed(evt);
            }
        });

        Name.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        Name.setText("User2");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(msg_text_s, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(send_btn_s, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text_s, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(send_btn_s))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_btn_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_btn_sActionPerformed
        // TODO add your handling code here:
        
        
      

        try {
            String msg;
            //
            msg = "";
            //ff is empty means file is not selected so normal msg needs to be send
            if(!ff.equals(""))
            {    byte b[]=new byte[1024];
                String sss;
                fis = new FileInputStream(new File(ff));     
                
                b[0]=-1;
                // b[0] equals -1 means what i'm sending is some kind of file
                // it is not a text msg
                int m;
               String[] arrOfStr = ff.split("/", 100);
               String fname = arrOfStr[arrOfStr.length - 1];
               // extractin file name from its path
                for(m=0;m<fname.length();m++){
			b[m+1]=(byte)(fname.charAt(m));		
		}
		b[++m]=(byte)(' ');
		b[m++]=(byte)(' ');
		dos.write(b, 0, 1024);
                //sending file name 
                int count = fis.read(b, 0, 1024);
                ff="";
                //reading and sending data of file
                while (count != -1) {
                 dos.write(b, 0, 1024);                    
                  count = fis.read(b, 0, 1024);
                 }
                
               
               msg_area_s.setText(msg_area_s.getText() + "\n                                                                                                            Me:  " + fname+" succesfully transferred");
               msg_text_s.setText(msg_text_s.getText() + ff);
               
                
                msg_text_s.setText(msg_text_s.getText() + ff);
            }  
            else{
                // this loop is running because ff is null meaning no file is selected
                byte b[]=new byte[1024];
                b[0]=0;
                dos.write(b, 0, 1024);
                // msg_area.setText("Waiting for the Server \n");
                 msg = msg_text_s.getText();
                  dos.writeUTF(msg);
                 msg_area_s.setText(msg_area_s.getText() + "\n                                                                                                              Me:  " + msg+ff);
            }
           
            msg_text_s.setText("");
           

        } catch (IOException e) {
            //exceptions
        }
        

    }//GEN-LAST:event_send_btn_sActionPerformed

    private void msg_text_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_text_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_text_sActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                        // TODO add your handling code here:
        try{
        JFileChooser chooser = new JFileChooser();
        // Choosing a file
        int vl=chooser.showOpenDialog(this);
        if(vl == JFileChooser.APPROVE_OPTION){
            
            try{
                 File fs = chooser.getSelectedFile();
                   ff = fs.getAbsolutePath();
                   msg_area_s.setText( msg_area_s.getText()+"\n                                                                              Me:"+ff+"\n                                                              succesfully chosen");
            }
            catch(Exception e){
                
            }
        }
        
       }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new server().setVisible(true);
        });

        try {
            String msgin = "";
            ss = new ServerSocket(8906);
            // Creating a server socket
            s = ss.accept();
            msg_area_s.setText("Client Found+\n");
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            msg_text_s.setText(" ");
            msg_area_s.setText(" ");
           while(true){
            byte bb[]=new byte[1024];
            int p=dis.read(bb,0,1024);
            // reading data from stream 
            if(p<1)
                continue;
            // p<1 meaning no data read
           // bb[0] = -1 meaning a read is a file
            if(bb[0]==-1){
                String fname="";
                
		int z=1;
		while((char)bb[z] !=' '){
			fname+=(char)bb[z];
			z++;		
		}
		z++;
		msg_area_s.setText(msg_area_s.getText() + "\nUser: "+fname+" Received and saved to\n/home/bhupendraprajapati/Desktop/");
		
		File f= new File("/home/bhupendraprajapati/Desktop/"+fname);
		
		byte bbb[]=new byte[1024];
		int count = dis.read(bbb,0,1024);
		
		FileOutputStream fos = new FileOutputStream(f);
              
		while(count!=-1){
			fos.write(bbb,0,count);
			count = dis.read(bbb,0,1024);
                        
		}
		
                
            }
            // what i read is text msg
            else{
           
                msgin = dis.readUTF();
                // Reading from stream
                msg_area_s.setText(msg_area_s.getText() + "\nUser: " + msgin);
                
             
            }
            }
            
          //  s.close();
           // ss.close();

        } catch (IOException e) {
            msg_area_s.setText(e + "Error Occured");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private static javax.swing.JTextArea msg_area_s;
    private static javax.swing.JTextField msg_text_s;
    private static javax.swing.JButton send_btn_s;
    // End of variables declaration//GEN-END:variables
}
