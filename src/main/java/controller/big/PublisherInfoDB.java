package controller.big;

import user.interf.MainOfFrame;
import user.interf.TextLabel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherInfoDB implements InfoDB {
    private final static PublisherInfoDB Publisher = new PublisherInfoDB();
    public static PublisherInfoDB getPublisher () { return Publisher; }
    private ArrayList<TextLabel> labels = new ArrayList<>();

    @Override
    public ArrayList<TextLabel> getLabels() {
        return labels;
    }

    @Override
    public void addTextLabel(TextLabel lab) {
        labels.add(lab);
    }

    @Override
    public void removeTextLabel(TextLabel lab) {
        labels.remove(lab);
    }

    @Override
    public void removeAllLabels() {
        labels.clear();
    }

    @Override
    public void notifySubscribers(ResultSet rs) {
        System.out.println("subscr: " + labels);
        for (TextLabel tl : labels) {
            tl.doAction(rs);
        }
    }

    public void createMessage (ResultSet rs) {
        System.out.println("publisher got message");
        notifySubscribers(rs);
    }
    private void saveInfoInLabel(ResultSet rs) {
        String name = null;
        String family = null;
        String age = null;
        try {
            if (rs.next()) {
                name = rs.getString("name");
                family = rs.getString("family");
                age = rs.getString("age");
            } else {
                MainOfFrame.fieldSearch.setText("Не найдено");
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }
//        MainOfFrame.labelFoundName.setText("Имя: " + name);
//        MainOfFrame.labelFoundFamily.setText("Фамилия: " + family);
//        MainOfFrame.labelFoundAge.setText("Возраст: " + age);

    }
}
