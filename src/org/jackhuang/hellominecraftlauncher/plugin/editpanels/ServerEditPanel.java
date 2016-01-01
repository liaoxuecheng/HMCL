/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jackhuang.hellominecraftlauncher.plugin.editpanels;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.table.DefaultTableModel;
import org.jackhuang.hellominecraftlauncher.apis.DoneListener;
import org.jackhuang.hellominecraftlauncher.apis.utils.Utils;
import org.jackhuang.hellominecraftlauncher.loaders.serverlist.ServerInfo;
import org.jackhuang.hellominecraftlauncher.loaders.serverlist.ServerList;
import org.jackhuang.hellominecraftlauncher.plugin.HMCLPlugin;
import org.jackhuang.hellominecraftlauncher.utilities.C;

/**
 *
 * @author hyh
 */
public class ServerEditPanel extends javax.swing.JPanel {

    /**
     * Creates new form ServerEditPanel
     */
    public ServerEditPanel() {
        initComponents();
        
        setName(C.I18N.getString("ServerEditor"));
        
        String[] titlesA = new String[]{C.I18N.getString("ServerName"), C.I18N.getString("HideAddress"), C.I18N.getString("Address"), C.I18N.getString("Introduction"), C.I18N.getString("Version"), C.I18N.getString("Online"), C.I18N.getString("Delay")};
        Class[] typesA = new Class[]{String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class};
        boolean[] canEditA = new boolean[]{false,false,false,false,false,false,false};
        lstServer.setModel(Utils.makeDefaultTableModel(titlesA, typesA, canEditA));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstServer = new javax.swing.JTable();
        btnRefreshServer = new javax.swing.JButton();
        btnAddServer = new javax.swing.JButton();
        btnDeleteServer = new javax.swing.JButton();
        btnEditServer = new javax.swing.JButton();

        setName(""); // NOI18N

        lstServer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "服务器名", "隐藏地址", "地址", "服务器介绍", "版本", "在线人数", "延迟"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(lstServer);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jackhuang/hellominecraftlauncher/I18N"); // NOI18N
        btnRefreshServer.setText(bundle.getString("刷新")); // NOI18N
        btnRefreshServer.setToolTipText("刷新列表");
        btnRefreshServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshServerActionPerformed(evt);
            }
        });

        btnAddServer.setText(bundle.getString("添加")); // NOI18N
        btnAddServer.setToolTipText("添加选中服务器");
        btnAddServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServerActionPerformed(evt);
            }
        });

        btnDeleteServer.setText(bundle.getString("删除")); // NOI18N
        btnDeleteServer.setToolTipText("删除选中服务器");
        btnDeleteServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServerActionPerformed(evt);
            }
        });

        btnEditServer.setText(bundle.getString("编辑")); // NOI18N
        btnEditServer.setToolTipText("编辑选中服务器");
        btnEditServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefreshServer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddServer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteServer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditServer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditServer)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshServerActionPerformed
        loadServers();
    }//GEN-LAST:event_btnRefreshServerActionPerformed

    private void btnAddServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServerActionPerformed
        ServerInfo info = new ServerInfo();
        DoneListener<ServerInfo, Object> l = new DoneListener<ServerInfo, Object>() {
            @Override
            public void onDone(ServerInfo info, Object value2) {
                sl.list.add(info);
                sl.write();
                Object[] row = makeRow(info);
                DefaultTableModel model = (DefaultTableModel) lstServer.getModel();
                model.addRow(row);
                new LoadServerThread(info, listener, row, model.getRowCount() - 1).start();
            }
        };
        ServerEditorWindow window = new ServerEditorWindow(null, true, info, l);
        window.setVisible(true);
    }//GEN-LAST:event_btnAddServerActionPerformed

    private void btnDeleteServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServerActionPerformed
        int idx = lstServer.getSelectedRow();
        if (idx == -1) {
            return;
        }
        sl.list.remove(idx);
        sl.write();
        DefaultTableModel model = (DefaultTableModel) lstServer.getModel();
        model.removeRow(idx);
        lstServer.updateUI();
    }//GEN-LAST:event_btnDeleteServerActionPerformed

    private void btnEditServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditServerActionPerformed
        final int selection = lstServer.getSelectedRow();

        ServerInfo info = sl.list.get(selection);
        DoneListener<ServerInfo, Object> l = new DoneListener<ServerInfo, Object>() {
            @Override
            public void onDone(ServerInfo info, Object value2) {
                sl.list.add(info);
                sl.write();
                final DefaultTableModel model = (DefaultTableModel) lstServer.getModel();
                Object[] row = new Object[7];
                for (int i = 0; i < 7; i++) {
                    row[i] = model.getValueAt(selection, i);
                }
                new LoadServerThread(info, new DoneListener<Object[], Integer>() {
                    @Override
                    public void onDone(Object[] value, Integer rowLine) {
                        for (int i = 0; i < value.length; i++) {
                            model.setValueAt(value[i], rowLine, i);
                        }
                        lstServer.updateUI();
                    }
                }, row, selection).start();
            }
        };

        ServerEditorWindow window = new ServerEditorWindow(null, true, info, l);
        window.setVisible(true);
    }//GEN-LAST:event_btnEditServerActionPerformed

    DefaultDoneListener listener = new DefaultDoneListener();
    ServerList sl;

    public void loadServers() {

        DefaultTableModel model = (DefaultTableModel) lstServer.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        String gameDir = Utils.getGameDir(HMCLPlugin.env.getVersion(), HMCLPlugin.env.getDefaultGameDir());
        File file = new File(gameDir + "servers.dat");
        if (file.exists()) {
            sl = new ServerList(file);
            for (ServerInfo info : sl.list) {
                Object[] row = makeRow(info);
                model.addRow(row);
                new LoadServerThread(info, listener, row, model.getRowCount() - 1).start();
            }
        } else {
            ServerList.writeEmptyFile(file);
            sl = new ServerList(file);
        }
    }

    class LoadServerThread extends Thread {

        ServerInfo info;
        DoneListener<Object[], Integer> listener;
        Object[] row;
        int rowNumber;

        public LoadServerThread(ServerInfo info, DoneListener<Object[], Integer> listener,
                Object[] row, int rowNumber) {
            this.info = info;
            this.listener = listener;
            this.row = row;
            this.rowNumber = rowNumber;
        }

        @Override
        public void run() {
            try {
                TimeZone begin = Calendar.getInstance().getTimeZone();

                String[] split = info.address.split(":");
                Socket socket;
                if (split.length >= 2) {
                    socket = new Socket(split[0], Utils.parseInt(split[1], 25565));
                } else {
                    socket = new Socket(split[0], 25565);
                }
                socket.setSoTimeout(5000);
                OutputStream os = socket.getOutputStream();
                byte[] writes = new byte[1];
                writes[0] = (byte) 254;
                os.write(writes, 0, 1);
                writes = new byte[1];
                writes[0] = (byte) 1;
                os.write(writes, 0, 1);
                InputStream is = socket.getInputStream();
                byte[] recive = new byte[512];
                int bytes = is.read(recive);
                if (recive[0] != -1) {
                    System.out.println(java.text.MessageFormat.format(C.I18N.getString("服务器{0}的回复无效"), new Object[]{info.name}));
                    return;
                }
                TimeZone end = Calendar.getInstance().getTimeZone();
                String message = new String(recive, 4, bytes - 4);
                StringBuilder remessage = new StringBuilder(30);
                for (int i = 0; i < message.length(); i += 2) {
                    remessage.append(message.charAt(i));
                }
                message = remessage.toString();
                os.close();
                is.close();
                socket.close();

                char[] achar = message.toCharArray();
                message = new String(achar);
                if (message.charAt(0) == (char) 253
                        || message.charAt(0) == (char) 65533) {
                    message = (char) 167 + message.substring(1);
                }
                String[] astring;
                if (message.startsWith("\u00a7") && message.length() > 1) {
                    astring = message.substring(1).split("\0");
                    if (Utils.parseInt(astring[0], 0) == 1) {
                        row[3] = astring[3];
                        row[4] = astring[2];
                        int online = Utils.parseInt(astring[4], 0);
                        int maxplayer = Utils.parseInt(astring[5], 0);
                        row[5] = online + "/" + maxplayer;
                    }
                } else {
                    row[3] = "";
                    row[4] = "";
                    row[5] = "";
                }
                int offset = (end.getRawOffset() - begin.getRawOffset());
                row[6] = offset + "ms";
                if (offset < 200) {
                    row[6] += C.I18N.getString(" 好 GREEN");
                } else if (offset < 500) {
                    row[6] += C.I18N.getString(" 较好 BLUE");
                } else if (offset < 1000) {
                    row[6] += C.I18N.getString(" 中 YELLOGREEN");
                } else if (offset < 3000) {
                    row[6] += C.I18N.getString(" 较差 ORANGE");
                } else {
                    row[6] += C.I18N.getString(" 差 ORANGERED");
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                //Logger.getLogger(I18N.class.getName()).log(Level.SEVERE, null, ex);
                row[6] = C.I18N.getString("无法连接");
            }
            listener.onDone(row, rowNumber);
        }
    }

    public class DefaultDoneListener implements DoneListener<Object[], Integer> {

        @Override
        public void onDone(Object[] row, Integer rowLine) {
            synchronized (ServerEditPanel.this) {
                DefaultTableModel model = (DefaultTableModel) lstServer.getModel();
                for (int i = 0; i < row.length; i++) {
                    model.setValueAt(row[i], rowLine, i);
                }
            }
        }
    }

    Object[] makeRow(ServerInfo info) {
        Object[] row = new Object[7];
        row[0] = info.name;
        row[1] = info.isHide;
        if (info.isHide) {
            row[2] = "";
        } else {
            row[2] = info.address;
        }
        row[6] = C.I18N.getString("连接中");
        return row;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddServer;
    private javax.swing.JButton btnDeleteServer;
    private javax.swing.JButton btnEditServer;
    private javax.swing.JButton btnRefreshServer;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable lstServer;
    // End of variables declaration//GEN-END:variables
}
