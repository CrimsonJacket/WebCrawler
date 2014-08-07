/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import page_utils.Page;
import threadhandle.ExecutorHandler;

/**
 *
 * @author Zheng Wei
 */
public class GUIv2 extends javax.swing.JFrame {

    private int emptyRow = 0;
    public static List<String> seeds = Collections.synchronizedList(new ArrayList<String>());
    public static ExecutorHandler ex;
    public static List<Page> donePages = Collections.synchronizedList(new ArrayList<Page>());
    public static int numberOfURLs = 15;
    public static DefaultTableModel dtm;
    private int noOfDownload = 5; 
    private int noOfProcess = 5;

    /**
     * Creates new form GUIv2
     */
    public GUIv2() {
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

        jFrame1 = new javax.swing.JFrame();
        sourceCodePanel = new javax.swing.JScrollPane();
        sourceCodeArea = new javax.swing.JTextArea();
        sourceCodeLabel = new javax.swing.JLabel();
        referencePanel = new javax.swing.JScrollPane();
        referenceList = new javax.swing.JList();
        referenceLabel = new javax.swing.JLabel();
        pageScrollPane = new javax.swing.JScrollPane();
        pageTable = new javax.swing.JTable(){
            public String getToolTipText(MouseEvent event){
                String tip = null;
                java.awt.Point p = event.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);

                if(realColumnIndex == 0){
                    tip = getValueAt(rowIndex, colIndex).toString();
                }else{
                    tip = super.getToolTipText(event);
                }
                return tip;
            }
        };
        buttonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        seedPanel = new javax.swing.JPanel();
        seedInput = new javax.swing.JTextField();
        seedLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        statusCode = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        closeBtn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        downloadThreadMenu = new javax.swing.JMenu();
        processingThreadMenu = new javax.swing.JMenu();

        sourceCodeArea.setEditable(false);
        sourceCodeArea.setColumns(20);
        sourceCodeArea.setLineWrap(true);
        sourceCodeArea.setRows(5);
        sourceCodePanel.setViewportView(sourceCodeArea);

        sourceCodeLabel.setText("Source Code:");

        referenceList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        referencePanel.setViewportView(referenceList);

        referenceLabel.setText("References:");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sourceCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceCodeLabel))
                .addGap(18, 18, 18)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(referenceLabel)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(referencePanel))
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceCodeLabel)
                    .addComponent(referenceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(referencePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(sourceCodePanel))
                .addGap(43, 43, 43))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebCrawler - Java");

        pageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "URL", " ", "Status", "No Of References"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pageTable.getColumn (" ").setCellRenderer(new ProgressBarRender());
        pageTable.setFillsViewportHeight (true);
        pageScrollPane.setViewportView(pageTable);
        ListSelectionListener listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getSource() == pageTable.getSelectionModel() && pageTable.getRowSelectionAllowed()) {
                    int first = e.getFirstIndex();
                    int last = e.getLastIndex();
                    try{
                        sourceCodeArea.setText(donePages.get(last).getContent().toString());
                        DefaultListModel model = new DefaultListModel();
                        for (String ref : donePages.get(last).getReferences()){
                            model.addElement(ref);
                        }
                        referenceList.setModel(model);
                    }catch(InterruptedException error){}
                    jFrame1.pack();
                    jFrame1.setTitle("Source Code & References - "+ donePages.get(last).getLink());
                    jFrame1.setVisible(true);
                } else if (e.getSource() == pageTable.getColumnModel().getSelectionModel()
                    && pageTable.getColumnSelectionAllowed()) {
                    int first = e.getFirstIndex();
                    int last = e.getLastIndex();
                    System.out.print(first);
                    System.out.print(last);
                }
                if (e.getValueIsAdjusting()) {
                    System.out.println("The mouse button has not yet been released");
                }
            }
        };
        pageTable.getColumnModel().getSelectionModel().addListSelectionListener(listener);
        pageTable.getSelectionModel().addListSelectionListener(listener);

        addButton.setLabel("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        submitButton.setLabel("Start");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(clearBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitButton)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearBtn))
        );

        seedInput.setText("Enter Website...");
        seedInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedInputActionPerformed(evt);
            }
        });
        seedInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                seedInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                seedInputFocusLost(evt);
            }
        });

        seedLabel.setText("Seed :");

        statusLabel.setText("Status : ");

        statusCode.setForeground(new java.awt.Color(0, 255, 0));
        statusCode.setText("Ready!");

        javax.swing.GroupLayout seedPanelLayout = new javax.swing.GroupLayout(seedPanel);
        seedPanel.setLayout(seedPanelLayout);
        seedPanelLayout.setHorizontalGroup(
            seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seedPanelLayout.createSequentialGroup()
                .addGroup(seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusLabel)
                    .addComponent(seedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusCode))
                .addGap(8, 8, 8))
        );
        seedPanelLayout.setVerticalGroup(
            seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(seedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusCode)))
        );

        jMenu1.setText("File");

        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        jMenu1.add(closeBtn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Set Number of Website to Crawl");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        downloadThreadMenu.setText("Number of Download Threads");
        jMenu2.add(downloadThreadMenu);
        downloadThreadBG = new ButtonGroup();
        ArrayList<JCheckBoxMenuItem> downloadThreadChoices = new ArrayList<JCheckBoxMenuItem>();
        for(int i = 1; i<11; i++){
            downloadThreadChoices.add(new JCheckBoxMenuItem(String.valueOf(i)));
        }
        for(JCheckBoxMenuItem checkbox : downloadThreadChoices){
            if (checkbox.getText().equals(String.valueOf(noOfDownload))){
                checkbox.setSelected(true);
            }
            checkbox.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent changeEvent){
                    JCheckBoxMenuItem checkbox = (JCheckBoxMenuItem)changeEvent.getSource();
                    if (checkbox.isSelected()) noOfDownload = Integer.parseInt(checkbox.getText());
                }
            });
            downloadThreadMenu.add(checkbox);
            downloadThreadBG.add(checkbox);
        }

        processingThreadMenu.setText("Number of Processing Threads");
        jMenu2.add(processingThreadMenu);
        ButtonGroup processThreadBG = new ButtonGroup();

        ArrayList<JCheckBoxMenuItem> processThreadChoices = new ArrayList<JCheckBoxMenuItem>();
        for(int i = 1; i<11; i++){
            processThreadChoices.add(new JCheckBoxMenuItem(String.valueOf(i)));
        }
        for(JCheckBoxMenuItem checkbox : processThreadChoices){
            if (checkbox.getText().equals(String.valueOf(noOfProcess))){
                checkbox.setSelected(true);
            }
            checkbox.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent changeEvent){
                    JCheckBoxMenuItem checkbox = (JCheckBoxMenuItem)changeEvent.getSource();
                    if (checkbox.isSelected()) noOfProcess = Integer.parseInt(checkbox.getText());
                }
            });
            processingThreadMenu.add(checkbox);
            processThreadBG.add(checkbox);
        }

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pageScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (seedInput.getText().matches("http://(\\w+\\.)+(\\w+)")) {
            if (seeds.contains(seedInput.getText())) {
                JOptionPane.showMessageDialog(pageScrollPane, "Url already inside list!", "Duplicated url", JOptionPane.INFORMATION_MESSAGE);
            } else {
                seeds.add(seedInput.getText());
                dtm = (DefaultTableModel) pageTable.getModel();
                dtm.addRow(new Object[][]{null, null, null, null});
                while (dtm.getValueAt(emptyRow, 0) != null) {
                    emptyRow++;
                }
                dtm.setValueAt(seedInput.getText(), emptyRow, 0);
                dtm.setValueAt(0, emptyRow, 1);
                dtm.setValueAt("Queued", emptyRow, 2);
            }
            seedInput.setText("Enter Website...");
        } else if (seedInput.getText().equals("Enter Website...")) {
            JOptionPane.showMessageDialog(pageScrollPane, "Please Enter a url.", "No Url", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(pageScrollPane, "Please Enter a valid url.", "Invalid url", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void seedInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seedInputActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        ex = new ExecutorHandler(noOfDownload, noOfProcess, seeds);
        ex.start();
        statusCode.setText("Crawling...");
        statusCode.setForeground(Color.red);
            //DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        //  for (int i = 0; i < dtm.getRowCount(); i++) {
        //    if(dtm.getValueAt(i, 2).toString().equals("Queued")){
        //      UrlHanderWorker uhw = new UrlHanderWorker(dtm, jTextField1.getText(), 0);
        //      uhw.execute();
        //    }
        //}

    }//GEN-LAST:event_submitButtonActionPerformed

    private void seedInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seedInputFocusGained
        // TODO add your handling code here:
        if (seedInput.getText().equals("Enter Website...")) {
            seedInput.setText("");
        }
    }//GEN-LAST:event_seedInputFocusGained

    private void seedInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_seedInputFocusLost
        // TODO add your handling code here:
        if (seedInput.getText().isEmpty()) {
            seedInput.setText("Enter Website...");
        }
    }//GEN-LAST:event_seedInputFocusLost

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        System.exit(ABORT);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        seeds.clear();
        donePages.clear();
        dtm.setRowCount(0);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int urlsSize = 0;
        do{
            String input = JOptionPane.showInputDialog("Enter number of website to crawl.");
            try{
                urlsSize = Integer.parseInt(input);
                if (urlsSize<=0){
                    JOptionPane.showMessageDialog(pageScrollPane, "Number of Urls cannot be less than 1.");
                    urlsSize = 0;
                }
            }catch (NumberFormatException e){
                urlsSize = 0;
            }
        }while(urlsSize==0);
        numberOfURLs = urlsSize;
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIv2().setVisible(true);
            }
        });
    }

    public class ProgressBarRender extends JProgressBar implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            int progress = 0;
            if (value instanceof Float) {
                progress = Math.round((float) value / 100);
                setValue(progress);
            } else if (value instanceof Integer) {
                progress = (int) value;
                setValue(progress);
            } else if (value instanceof String) {
                setString((String) value);
            }
            setStringPainted(true);
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton clearBtn;
    private javax.swing.JMenuItem closeBtn;
    private javax.swing.JMenu downloadThreadMenu;
    private javax.swing.ButtonGroup downloadThreadBG;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane pageScrollPane;
    private javax.swing.JTable pageTable;
    private javax.swing.JMenu processingThreadMenu;
    private javax.swing.JLabel referenceLabel;
    private javax.swing.JList referenceList;
    private javax.swing.JScrollPane referencePanel;
    private javax.swing.JTextField seedInput;
    private javax.swing.JLabel seedLabel;
    private javax.swing.JPanel seedPanel;
    private javax.swing.JTextArea sourceCodeArea;
    private javax.swing.JLabel sourceCodeLabel;
    private javax.swing.JScrollPane sourceCodePanel;
    public static javax.swing.JLabel statusCode;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
