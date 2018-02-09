/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.russianpost.siberia.monitorticket;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import ru.russianpost.siberia.GetTicket;
import ru.russianpost.siberia.GetTicketResponse;
import ru.russianpost.siberia.GetTicketSessionSRV;
import ru.russianpost.siberia.GetTicketSessionSRV_Service;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//ru.russianpost.siberia.monitorticket//SearchTicket//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SearchTicketTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "ru.russianpost.siberia.monitorticket.SearchTicketTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SearchTicketAction",
        preferredID = "SearchTicketTopComponent"
)
@Messages({
    "CTL_SearchTicketAction=Поиск по ШПИ",
    "CTL_SearchTicketTopComponent=Поиск РПО по ШПИ",
    "HINT_SearchTicketTopComponent=This is a SearchTicket window"
})
public final class SearchTicketTopComponent extends TopComponent {

    public SearchTicketTopComponent() {
        initComponents();
        setName(Bundle.CTL_SearchTicketTopComponent());
        setToolTipText(Bundle.HINT_SearchTicketTopComponent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        edBarcode = new javax.swing.JTextField();
        btGetTicket = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SearchTicketTopComponent.class, "SearchTicketTopComponent.jLabel1.text")); // NOI18N

        edBarcode.setText(org.openide.util.NbBundle.getMessage(SearchTicketTopComponent.class, "SearchTicketTopComponent.edBarcode.text")); // NOI18N
        edBarcode.setToolTipText(org.openide.util.NbBundle.getMessage(SearchTicketTopComponent.class, "SearchTicketTopComponent.edBarcode.toolTipText")); // NOI18N
        edBarcode.setName(""); // NOI18N
        edBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edBarcodeActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btGetTicket, org.openide.util.NbBundle.getMessage(SearchTicketTopComponent.class, "SearchTicketTopComponent.btGetTicket.text")); // NOI18N
        btGetTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetTicketActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGetTicket)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGetTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edBarcodeActionPerformed
        btGetTicketActionPerformed(evt);
    }//GEN-LAST:event_edBarcodeActionPerformed

    private void btGetTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetTicketActionPerformed
        util.changeCursorWaitStatus(true);
        try {
            GetTicketSessionSRV_Service service = new GetTicketSessionSRV_Service();
            GetTicketSessionSRV port = service.getGetTicketSessionSRVPort();
            GetTicket parameters = new GetTicket();
            parameters.setBarcode(edBarcode.getText().toUpperCase());
            GetTicketResponse result = port.getTicket(parameters);
            ViewhistoryModel tm = new ViewhistoryModel(result.getReturn());
            jTable.setModel(tm);
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            util.LogErr(ex.getMessage());
        }
        util.changeCursorWaitStatus(false);
    }//GEN-LAST:event_btGetTicketActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGetTicket;
    private javax.swing.JTextField edBarcode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        //        login = NbPreferences.forModule(MonitorTicketPanel.class).get("login", "");
        //        password = NbPreferences.forModule(MonitorTicketPanel.class).get("password", "");
    }
}
