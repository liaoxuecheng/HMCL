/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jackhuang.hellominecraftlauncher.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import org.jackhuang.hellominecraftlauncher.apis.utils.MessageBox;
import org.jackhuang.hellominecraftlauncher.utilities.SettingsManager;
import org.jackhuang.hellominecraftlauncher.apis.utils.Utils;
import org.jackhuang.hellominecraftlauncher.settings.Version;
import org.jackhuang.hellominecraftlauncher.utilities.C;
import org.jackhuang.hellominecraftlauncher.apis.utils.MinecraftVersionRequest;

/**
 *
 * @author hyh
 */
public class NewVersionWindow extends javax.swing.JDialog {

    Version version;

    /**
     * Creates new form VersionSettingsWindow
     */
    public NewVersionWindow(java.awt.Frame parent, boolean modal, Version v) {
        super(parent, modal);
        initComponents();

        version = v;

        txtMaxMemory.setText(version.maxMemory);
        txtName.setText(version.name);
        txtGameDir.setText(version.gameDir);
        txtJavaArgs.setText(version.javaArgs);
        txtJavaDir.setText(version.javaDir);
        chkOver16.setSelected(version.isVer16);

        if (version.lastLoadLibraries == null) {
            version.lastLoadLibraries = new ArrayList<String>();
        }
        if (version.firstLoadLibraries == null) {
            version.firstLoadLibraries = new ArrayList<String>();
        }

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrSize.width - this.getWidth()) / 2,
                (scrSize.height - this.getHeight()) / 2);

    }

    void loadMinecraftVersion() {
        java.util.ResourceBundle bundle = C.I18N; // NOI18N
        String minecraftJar;
        if (version.isVer16) {
            minecraftJar = Utils.addSeparator(Utils.getGameDir(version, SettingsManager.settings.publicSettings.gameDir))
                    + "versions" + File.separator + version.name + File.separator
                    + version.name + ".jar";
        } else {
            minecraftJar = Utils.addSeparator(Utils.getGameDir(version, SettingsManager.settings.publicSettings.gameDir)) + "bin"
                    + File.separator + "minecraft.jar";
        }
        minecraftVersion = Utils.minecraftVersion(new File(minecraftJar));
        String text = "";
        switch (minecraftVersion.type) {
            case MinecraftVersionRequest.Invaild:
                text = bundle.getString("invalid");
                break;
            case MinecraftVersionRequest.InvaildJar:
                text = bundle.getString("invalid_jar");
                break;
            case MinecraftVersionRequest.NotAFile:
                text = bundle.getString("not_a_file");
                break;
            case MinecraftVersionRequest.NotFound:
                text = bundle.getString("not_found");
                break;
            case MinecraftVersionRequest.NotReadable:
                text = bundle.getString("not_readable");
                break;
            case MinecraftVersionRequest.Modified:
                text = bundle.getString("modified") + " ";
            case MinecraftVersionRequest.OK:
                text += minecraftVersion.version;
                break;
            case MinecraftVersionRequest.Unkown:
            default:
                text = "???";
                break;
        }
        txtMinecraftVersion.setText(text);
    }

    int getCharShowTime(String s, char c) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res++;
            }
        }
        return res;
    }

    String formatVersion(String ver) {
        int i = (getCharShowTime(ver, '.'));
        if (i == 0) {
            if (getCharShowTime(ver, 'w') > 0) {
                return ver;
            } else {
                return ver + ".0.0";
            }
        } else if (i == 1) {
            return ver + ".0";
        } else {
            return ver;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtGameDir = new javax.swing.JTextField();
        txtJavaDir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtJavaArgs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMaxMemory = new javax.swing.JTextField();
        chkOver16 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        txtMinecraftVersion = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jackhuang/hellominecraftlauncher/I18N"); // NOI18N
        jLabel1.setText(bundle.getString("名称")); // NOI18N
        jLabel1.setToolTipText("");

        btnOK.setText(bundle.getString("确定")); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText(bundle.getString("取消")); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(bundle.getString("以下设置字段为空代表着使用默认设置")); // NOI18N

        jLabel7.setText(bundle.getString("游戏路径")); // NOI18N

        jLabel11.setText(bundle.getString("JAVA路径")); // NOI18N

        jLabel6.setText(bundle.getString("JAVA虚拟机参数")); // NOI18N

        jLabel10.setText(bundle.getString("最大内存")); // NOI18N

        chkOver16.setText(bundle.getString("1.6及以上版本以及导入的旧版本")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGameDir)
                    .addComponent(txtJavaDir)
                    .addComponent(txtMaxMemory)
                    .addComponent(txtJavaArgs)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                        .addComponent(chkOver16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(chkOver16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGameDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJavaDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJavaArgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaxMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("普通设置", jPanel1);

        jLabel13.setText("Minecraft 版本");

        txtMinecraftVersion.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTabbedPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinecraftVersion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOK)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMinecraftVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void chkAdvancedSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAdvancedSettingsActionPerformed
    }//GEN-LAST:event_chkAdvancedSettingsActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        if (txtName.getText().trim().isEmpty()) {
            MessageBox.Show(C.I18N.getString("版本名称不能为空"));
            return;
        }

        version.gameDir = txtGameDir.getText();
        version.isVer16 = chkOver16.isSelected();
        version.javaArgs = txtJavaArgs.getText();
        version.javaDir = txtJavaDir.getText();
        version.maxMemory = txtMaxMemory.getText();
        version.name = txtName.getText();
        SettingsManager.setVersion(version);
        SettingsManager.save();

        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    int progress, max;
    MinecraftVersionRequest minecraftVersion;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox chkOver16;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtGameDir;
    private javax.swing.JTextField txtJavaArgs;
    private javax.swing.JTextField txtJavaDir;
    private javax.swing.JTextField txtMaxMemory;
    private javax.swing.JTextField txtMinecraftVersion;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
