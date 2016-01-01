/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jackhuang.hellominecraftlauncher.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.jackhuang.hellominecraftlauncher.apis.Plugin;
import org.jackhuang.hellominecraftlauncher.apis.utils.MessageBox;
import org.jackhuang.hellominecraftlauncher.apis.utils.Utils;
import org.jackhuang.hellominecraftlauncher.plugin.PluginHandler;
import org.jackhuang.hellominecraftlauncher.plugin.PluginManager;
import org.jackhuang.hellominecraftlauncher.utilities.C;
import org.jackhuang.hellominecraftlauncher.utilities.SettingsManager;

/**
 *
 * @author hyh
 */
public class OptionsWindow extends javax.swing.JDialog {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    DefaultListModel lstPluginsModel = new DefaultListModel();
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">  
    public OptionsWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrSize.width - this.getWidth()) / 2,
                (scrSize.height - this.getHeight()) / 2);
        
        preparePlugins();
        txtBackgroundPath.setText(MainWindow.getInstance().backgroundPath);
        cboSource.setSelectedIndex(SettingsManager.settings.downloadtype);
        
        txtMaxMemory.setText(String.valueOf(SettingsManager.settings.publicSettings.maxMemory));
        txtMinecraftPath.setText(SettingsManager.settings.publicSettings.gameDir);
        chkDisableMoveMods.setSelected(SettingsManager.settings.disableMoveMods);
        
        for (JPanel panel : PluginHandler.mainPanels) {
            tabMain.addTab(panel.getName(), panel);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Load">  
    private void preparePlugins() {
        lstPluginsModel.clear();
        for (Plugin p : PluginManager.pluginAnnotations) {
            lstPluginsModel.addElement(p.pluginName());
        }
        lstPlugins.setModel(lstPluginsModel);
    }

    private void prepareAPlugin(int idx) {
        Plugin p = PluginManager.pluginAnnotations.get(idx);
        lblPluginName.setText(p.pluginName());
        lblPluginVersion.setText(p.pluginVer());
        lblPluginAuthors.setText(p.authors());
        txtPluginDescription.setText(p.description());
        lblPluginActive.setText(PluginManager.pluginError.get(idx) == null ? C.I18N.getString("Loaded") : C.I18N.getString("FailedToLoad"));
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Statics">
    static {
        instance = new OptionsWindow(null, true);
    }
    
    public static OptionsWindow getInstance() {
        return instance;
    }
    
    private static OptionsWindow instance;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="UI">  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlCard = new javax.swing.JPanel();
        tabMain = new javax.swing.JTabbedPane();
        pnlPublicSettings = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaxMemory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMinecraftPath = new javax.swing.JTextField();
        btnSelMinecraftPath = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        chkDisableMoveMods = new javax.swing.JCheckBox();
        cboSource = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPlugins = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblPluginName = new javax.swing.JLabel();
        lblPluginVersion = new javax.swing.JLabel();
        lblPluginAuthors = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPluginDescription = new javax.swing.JTextPane();
        btnPluginSettings = new javax.swing.JButton();
        lblPluginActive = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBackgroundPath = new javax.swing.JTextField();
        btnSelBackgroundPath = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jackhuang/hellominecraftlauncher/I18N"); // NOI18N
        setTitle(bundle.getString("Options")); // NOI18N

        pnlCard.setLayout(new java.awt.CardLayout());

        tabMain.setName("tabMain"); // NOI18N

        jLabel3.setText("MB");

        txtMaxMemory.setToolTipText(bundle.getString("MaxMemoryTooltip")); // NOI18N
        txtMaxMemory.setName("txtMaxMemory"); // NOI18N
        txtMaxMemory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaxMemoryFocusLost(evt);
            }
        });

        jLabel2.setText(bundle.getString("游戏路径")); // NOI18N
        jLabel2.setToolTipText("");

        jLabel1.setText(bundle.getString("最大内存")); // NOI18N

        txtMinecraftPath.setToolTipText(bundle.getString("MinecraftLocation")); // NOI18N
        txtMinecraftPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinecraftPathFocusLost(evt);
            }
        });

        btnSelMinecraftPath.setText(bundle.getString("手动设置")); // NOI18N
        btnSelMinecraftPath.setToolTipText("");
        btnSelMinecraftPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelMinecraftPathActionPerformed(evt);
            }
        });

        jButton1.setText(bundle.getString("查看日志")); // NOI18N
        jButton1.setToolTipText(bundle.getString("ShowConsoleOutput")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chkDisableMoveMods.setText(bundle.getString("DisableMoveMods")); // NOI18N
        chkDisableMoveMods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDisableMoveModsActionPerformed(evt);
            }
        });

        cboSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mojang", "BMCL" }));
        cboSource.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSourceItemStateChanged(evt);
            }
        });

        jLabel5.setText(bundle.getString("DownloadSource")); // NOI18N

        javax.swing.GroupLayout pnlPublicSettingsLayout = new javax.swing.GroupLayout(pnlPublicSettings);
        pnlPublicSettings.setLayout(pnlPublicSettingsLayout);
        pnlPublicSettingsLayout.setHorizontalGroup(
            pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPublicSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMinecraftPath)
                    .addGroup(pnlPublicSettingsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelMinecraftPath))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPublicSettingsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaxMemory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(pnlPublicSettingsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPublicSettingsLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(chkDisableMoveMods)))
                .addContainerGap())
        );
        pnlPublicSettingsLayout.setVerticalGroup(
            pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPublicSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelMinecraftPath)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMinecraftPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaxMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboSource, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(pnlPublicSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDisableMoveMods)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        tabMain.addTab("全局设置", pnlPublicSettings);

        jLabel4.setText("<html>\n作者：<br />\n百度ID：huanghongxun20<br />\nmcbbs：huanghongxun<br />\n邮箱：huanghongxun2008@126.com<br />\n<br />\n欢迎举报Bug哦\n</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabMain.addTab("检查更新", jPanel2);

        lstPlugins.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPluginsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPlugins);

        jLabel14.setText(bundle.getString("Name")); // NOI18N

        jLabel15.setText(bundle.getString("Version")); // NOI18N

        jLabel16.setText(bundle.getString("Authors")); // NOI18N

        jLabel17.setText(bundle.getString("Details")); // NOI18N

        lblPluginName.setText("0");

        lblPluginVersion.setText("0");

        lblPluginAuthors.setText("0");

        jScrollPane3.setViewportView(txtPluginDescription);

        btnPluginSettings.setText(bundle.getString("PluginSettings")); // NOI18N
        btnPluginSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPluginSettingsActionPerformed(evt);
            }
        });

        lblPluginActive.setText(bundle.getString("IsLoaded")); // NOI18N
        lblPluginActive.setToolTipText(bundle.getString("ShowIfIsLoaded")); // NOI18N
        lblPluginActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPluginActiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPluginName))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPluginVersion))
                            .addComponent(jLabel17)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPluginAuthors)))
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(lblPluginActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(btnPluginSettings)
                        .addContainerGap())))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblPluginName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblPluginVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblPluginAuthors))
                .addGap(44, 44, 44)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPluginSettings)
                    .addComponent(lblPluginActive))
                .addContainerGap())
        );

        tabMain.addTab("插件中心", jPanel18);

        jLabel6.setText(bundle.getString("背景地址")); // NOI18N
        jLabel6.setToolTipText("");

        txtBackgroundPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBackgroundPathFocusLost(evt);
            }
        });

        btnSelBackgroundPath.setText(bundle.getString("手动设置")); // NOI18N
        btnSelBackgroundPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelBackgroundPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBackgroundPath, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelBackgroundPath)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBackgroundPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelBackgroundPath))
                .addContainerGap(286, Short.MAX_VALUE))
        );

        tabMain.addTab("个性化", jPanel1);

        pnlCard.add(tabMain, "card2");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Events">  
    private void txtMaxMemoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaxMemoryFocusLost
        SettingsManager.settings.publicSettings.maxMemory = txtMaxMemory.getText();
        SettingsManager.save();
    }//GEN-LAST:event_txtMaxMemoryFocusLost

    private void txtMinecraftPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinecraftPathFocusLost
        SettingsManager.settings.publicSettings.gameDir = Utils.removeLastSeparator(txtMinecraftPath.getText());
        SettingsManager.save();
        MainWindow.getInstance().onRefreshMinecrafts();
    }//GEN-LAST:event_txtMinecraftPathFocusLost

    private void btnSelMinecraftPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelMinecraftPathActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle(C.I18N.getString("选择MINECRAFT路径"));
        fc.setMultiSelectionEnabled(false);
        fc.showOpenDialog(this);
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            path = Utils.removeLastSeparator(path);
            txtMinecraftPath.setText(path);
            SettingsManager.settings.publicSettings.gameDir = path;
            SettingsManager.save();
        } catch (Exception e) {
            MessageBox.Show(C.I18N.getString("设置失败：") + e.getMessage());
        }
    }//GEN-LAST:event_btnSelMinecraftPathActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LogWindow.instance.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkDisableMoveModsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDisableMoveModsActionPerformed
        SettingsManager.settings.disableMoveMods = chkDisableMoveMods.isSelected();
        SettingsManager.save();
    }//GEN-LAST:event_chkDisableMoveModsActionPerformed

    private void cboSourceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSourceItemStateChanged
        SettingsManager.settings.downloadtype = cboSource.getSelectedIndex();
        SettingsManager.save();
    }//GEN-LAST:event_cboSourceItemStateChanged

    private void lstPluginsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPluginsValueChanged
        prepareAPlugin(lstPlugins.getSelectedIndex());
    }//GEN-LAST:event_lstPluginsValueChanged

    private void btnPluginSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPluginSettingsActionPerformed
        PluginManager.showSettingsDialog(lstPlugins.getSelectedIndex());
    }//GEN-LAST:event_btnPluginSettingsActionPerformed

    private void lblPluginActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPluginActiveMouseClicked
        MessageBox.Show(PluginManager.pluginError.get(lstPlugins.getSelectedIndex()));
    }//GEN-LAST:event_lblPluginActiveMouseClicked

    private void txtBackgroundPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBackgroundPathFocusLost
        String path = txtBackgroundPath.getText();
        SettingsManager.settings.bgpath = path;
        SettingsManager.save();
        MainWindow.getInstance().onResizeBackgroundLabel(path);
    }//GEN-LAST:event_txtBackgroundPathFocusLost

    private void btnSelBackgroundPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelBackgroundPathActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle(C.I18N.getString("选择背景路径"));
        fc.setMultiSelectionEnabled(false);
        fc.showOpenDialog(this);
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            path = Utils.removeLastSeparator(path);
            txtBackgroundPath.setText(path);
            SettingsManager.settings.bgpath = path;
            SettingsManager.save();
            MainWindow.getInstance().onResizeBackgroundLabel(path);
        } catch (Exception e) {
            MessageBox.Show(C.I18N.getString("设置失败：") + e.getMessage());
        }
    }//GEN-LAST:event_btnSelBackgroundPathActionPerformed
    // </editor-fold>
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPluginSettings;
    private javax.swing.JButton btnSelBackgroundPath;
    private javax.swing.JButton btnSelMinecraftPath;
    private javax.swing.JComboBox cboSource;
    private javax.swing.JCheckBox chkDisableMoveMods;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPluginActive;
    private javax.swing.JLabel lblPluginAuthors;
    private javax.swing.JLabel lblPluginName;
    private javax.swing.JLabel lblPluginVersion;
    private javax.swing.JList lstPlugins;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPublicSettings;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JTextField txtBackgroundPath;
    private javax.swing.JTextField txtMaxMemory;
    private javax.swing.JTextField txtMinecraftPath;
    private javax.swing.JTextPane txtPluginDescription;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
