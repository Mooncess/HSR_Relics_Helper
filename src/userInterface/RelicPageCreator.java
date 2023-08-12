package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RelicPageCreator {
	public static JPanel createRelicPage() {
		JPanel relicPage = new JPanel(new BorderLayout(10, 10));
       
        // relicPage.setLayout(new GridLayout(4, 1));
        
        relicPage.setLayout(new FlowLayout());
        
        Dimension sizeForMiddlePanel = new Dimension(400, 30);
        Dimension sizeForButtonPanel = new Dimension(400, 30);
        Dimension sizeForMainStatPanel = new Dimension(400, 240);
        Dimension sizeForSubStatPanel = new Dimension(400, 200);
        
        JPanel middlePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel mainStatPanel = new JPanel();
        JPanel subStatPanel = new JPanel();
        
        
        middlePanel.setPreferredSize(sizeForMiddlePanel);
        buttonPanel.setPreferredSize(sizeForButtonPanel);
        mainStatPanel.setPreferredSize(sizeForMainStatPanel);
        subStatPanel.setPreferredSize(sizeForSubStatPanel);
        
        String filePath = "src/gameData/RelicSet.txt";
        List<String> relicList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	relicList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Создание элементов списка
        String[] relics = new String[relicList.size()];
        
        for (int i = 0; i < relicList.size(); i++) {
        	relics[i] = relicList.get(i); // преобразуем строку в значение enum
        }

        // Создание выпадающего списка
        JComboBox<String> comboBox = new JComboBox<>(relics);
        JLabel middleLabel = new JLabel("<html><u>Relic Set</u>: </html>");
        middlePanel.add(middleLabel);
        middlePanel.add(comboBox);
        
        JRadioButton head = new JRadioButton("Head");
        JRadioButton hands = new JRadioButton("Hands");
        JRadioButton body = new JRadioButton("Body");
        JRadioButton feet = new JRadioButton("Feet");
        
        JRadioButton mHP = new JRadioButton("HP");
        JRadioButton mATK = new JRadioButton("ATK");
        JRadioButton mSPD = new JRadioButton("SPD");
        JRadioButton mHPp = new JRadioButton("HP%");
        JRadioButton mATKp = new JRadioButton("ATK%");
        JRadioButton mDEFp = new JRadioButton("DEF%");
        JRadioButton mBreakeEffect = new JRadioButton("BREAK  EFFECT");
        JRadioButton mEffectHitRate = new JRadioButton("EFFECT HIT RATE");
        JRadioButton mEnergyRegenarationRate = new JRadioButton("ENERGY REGENERATION RATE");
        JRadioButton mOutgoingHealingBoost = new JRadioButton("OUTGOING HEALING BOOST");
        JRadioButton mPhysicalDMGBoost = new JRadioButton("PHYSICAL DMG BOOST");
        JRadioButton mFireDMGBoost = new JRadioButton("FIRE DMG BOOST");
        JRadioButton mIceDMGBoost = new JRadioButton("ICE DMG BOOST");
        JRadioButton mWindDMGBoost = new JRadioButton("WIND DMG BOOST");
        JRadioButton mLightingDMGBoost = new JRadioButton("LIGHTNING DMG BOOST");
        JRadioButton mQuantumDMGBoost = new JRadioButton("QUANTUM DMG BOOST");
        JRadioButton mImaginaryDMGBoost = new JRadioButton("IMAGINARY DMG BOOST");
        JRadioButton mCritRate = new JRadioButton("CRIT RATE");
        JRadioButton mCritDMG = new JRadioButton("CRIT DMG");
        
        head.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setSelected(true);
            	mHP.setEnabled(false);
            	mATK.setEnabled(false);
            	mSPD.setEnabled(false);
            	mHPp.setEnabled(false);
            	mATKp.setEnabled(false);
            	mDEFp.setEnabled(false);
            	mBreakeEffect.setEnabled(false);
            	mEffectHitRate.setEnabled(false);
            	mEnergyRegenarationRate.setEnabled(false);
            	mOutgoingHealingBoost.setEnabled(false);
            	mPhysicalDMGBoost.setEnabled(false);
            	mFireDMGBoost.setEnabled(false);
            	mIceDMGBoost.setEnabled(false);
            	mWindDMGBoost.setEnabled(false);
            	mLightingDMGBoost.setEnabled(false);
            	mQuantumDMGBoost.setEnabled(false);
            	mImaginaryDMGBoost.setEnabled(false);
            	mCritRate.setEnabled(false);
            	mCritDMG.setEnabled(false);
            }
        });
        
        hands.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mATK.setSelected(true);
            	mHP.setEnabled(false);
            	mATK.setEnabled(false);
            	mSPD.setEnabled(false);
            	mHPp.setEnabled(false);
            	mATKp.setEnabled(false);
            	mDEFp.setEnabled(false);
            	mBreakeEffect.setEnabled(false);
            	mEffectHitRate.setEnabled(false);
            	mEnergyRegenarationRate.setEnabled(false);
            	mOutgoingHealingBoost.setEnabled(false);
            	mPhysicalDMGBoost.setEnabled(false);
            	mFireDMGBoost.setEnabled(false);
            	mIceDMGBoost.setEnabled(false);
            	mWindDMGBoost.setEnabled(false);
            	mLightingDMGBoost.setEnabled(false);
            	mQuantumDMGBoost.setEnabled(false);
            	mImaginaryDMGBoost.setEnabled(false);
            	mCritRate.setEnabled(false);
            	mCritDMG.setEnabled(false);
            }
        });
        
        body.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setEnabled(true);
            	mATK.setEnabled(true);
            	mSPD.setEnabled(true);
            	mHPp.setEnabled(true);
            	mATKp.setEnabled(true);
            	mDEFp.setEnabled(true);
            	mBreakeEffect.setEnabled(true);
            	mEffectHitRate.setEnabled(true);
            	mEnergyRegenarationRate.setEnabled(true);
            	mOutgoingHealingBoost.setEnabled(true);
            	mPhysicalDMGBoost.setEnabled(true);
            	mFireDMGBoost.setEnabled(true);
            	mIceDMGBoost.setEnabled(true);
            	mWindDMGBoost.setEnabled(true);
            	mLightingDMGBoost.setEnabled(true);
            	mQuantumDMGBoost.setEnabled(true);
            	mImaginaryDMGBoost.setEnabled(true);
            	mCritRate.setEnabled(true);
            	mCritDMG.setEnabled(true);
            }
        });
        
        feet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setEnabled(true);
            	mATK.setEnabled(true);
            	mSPD.setEnabled(true);
            	mHPp.setEnabled(true);
            	mATKp.setEnabled(true);
            	mDEFp.setEnabled(true);
            	mBreakeEffect.setEnabled(true);
            	mEffectHitRate.setEnabled(true);
            	mEnergyRegenarationRate.setEnabled(true);
            	mOutgoingHealingBoost.setEnabled(true);
            	mPhysicalDMGBoost.setEnabled(true);
            	mFireDMGBoost.setEnabled(true);
            	mIceDMGBoost.setEnabled(true);
            	mWindDMGBoost.setEnabled(true);
            	mLightingDMGBoost.setEnabled(true);
            	mQuantumDMGBoost.setEnabled(true);
            	mImaginaryDMGBoost.setEnabled(true);
            	mCritRate.setEnabled(true);
            	mCritDMG.setEnabled(true);
            }
        });
        
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(head); buttonGroup1.add(hands);
        buttonGroup1.add(body); buttonGroup1.add(feet);
        
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(mHP);
        buttonGroup2.add(mATK);
        buttonGroup2.add(mSPD);
        buttonGroup2.add(mHPp);
        buttonGroup2.add(mATKp);
        buttonGroup2.add(mDEFp);
        buttonGroup2.add(mBreakeEffect);
        buttonGroup2.add(mEffectHitRate);
        buttonGroup2.add(mEnergyRegenarationRate);
        buttonGroup2.add(mOutgoingHealingBoost);
        buttonGroup2.add(mPhysicalDMGBoost);
        buttonGroup2.add(mFireDMGBoost);
        buttonGroup2.add(mIceDMGBoost);
        buttonGroup2.add(mWindDMGBoost);
        buttonGroup2.add(mLightingDMGBoost);
        buttonGroup2.add(mQuantumDMGBoost);
        buttonGroup2.add(mImaginaryDMGBoost);
        buttonGroup2.add(mCritRate);
        buttonGroup2.add(mCritDMG);
        
        JLabel buttonLabel = new JLabel("<html><u>Equipment</u>: </html>");
        buttonPanel.add(buttonLabel);
        
        buttonPanel.add(head); buttonPanel.add(hands);
        buttonPanel.add(body); buttonPanel.add(feet);
        
        JLabel mainStatLabel = new JLabel("<html><u>Main stat</u>: </html>");
        mainStatPanel.add(mainStatLabel);
        
        mainStatPanel.add(mHP);
        mainStatPanel.add(mATK);
        mainStatPanel.add(mSPD);
        mainStatPanel.add(mHPp);
        mainStatPanel.add(mATKp);
        mainStatPanel.add(mDEFp);
        mainStatPanel.add(mBreakeEffect);
        mainStatPanel.add(mEffectHitRate);
        mainStatPanel.add(mEnergyRegenarationRate);
        mainStatPanel.add(mOutgoingHealingBoost);
        mainStatPanel.add(mPhysicalDMGBoost);
        mainStatPanel.add(mFireDMGBoost);
        mainStatPanel.add(mIceDMGBoost);
        mainStatPanel.add(mWindDMGBoost);
        mainStatPanel.add(mLightingDMGBoost);
        mainStatPanel.add(mQuantumDMGBoost);
        mainStatPanel.add(mImaginaryDMGBoost);
        mainStatPanel.add(mCritRate);
        mainStatPanel.add(mCritDMG);

        JCheckBox spd = new JCheckBox("SPD");
        JCheckBox hp = new JCheckBox("HP");
        JCheckBox atk = new JCheckBox("ATK");
        JCheckBox def = new JCheckBox("DEF");
        JCheckBox hpp = new JCheckBox("HP%");
        JCheckBox atkp = new JCheckBox("ATK%");
        JCheckBox defp = new JCheckBox("DEF%");
        JCheckBox breakEffect = new JCheckBox("BREAK EFFECT");
        JCheckBox effectHitRate = new JCheckBox("EFFECT HIT RATE");
        JCheckBox effectRes = new JCheckBox("EFFECT RES");
        JCheckBox critRate = new JCheckBox("CRIT RATE");
        JCheckBox critDmg = new JCheckBox("CRIT DMG");
        
        JLabel subStatLabel = new JLabel("<html><u>Subsidiary stats</u>: </html>");
        subStatPanel.add(subStatLabel);
        subStatPanel.add(spd);
        subStatPanel.add(hp);
        subStatPanel.add(atk);
        subStatPanel.add(def);
        subStatPanel.add(hpp);
        subStatPanel.add(atkp);
        subStatPanel.add(defp);
        subStatPanel.add(breakEffect);
        subStatPanel.add(effectHitRate);
        subStatPanel.add(effectRes);
        subStatPanel.add(critRate);
        subStatPanel.add(critDmg);
        
        relicPage.add(middlePanel);
        relicPage.add(buttonPanel);
        relicPage.add(mainStatPanel);
        relicPage.add(subStatPanel);
        
        return relicPage;
    }
}
