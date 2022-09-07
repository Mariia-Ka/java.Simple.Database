package user.interf;

import controller.big.PublisherInfoDB;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TextLabel extends JLabel implements TextLabelListener{
    String text;
    String title;

    public TextLabel (String text, String title, Container cont) {
        this.text = text;
        this.title = title;
        this.setText(text);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        Font bigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        this.setFont(bigFontTR);
//        PublisherInfoDB pDB = new PublisherInfoDB();
//        pDB.addTextLabel(this);
        cont.add(this);
    }
    public TextLabel getLabel () {
        return this;
    }
    @Override
    public void doAction (ResultSet rs) {
        System.out.println("do ACTION");
        try {
            while (rs.next()) {
                this.setText(text + rs.getString(title));
            }
            rs.absolute(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
