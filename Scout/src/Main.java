import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, Team> getTeamsMap() {
        Team Excalibur = new Team(6738, "Excalibur", 2017, "Modiin", 0,0,0,0);
        Team GreenBlitz = new Team(4590, "GreenBlitz", 2015, "Hakfar Hatarok", 0,0,0,0);
        Team SteamPunk = new Team(1577, "SteamPunk", 2015, "Ranana", 0,0,0,0);
        Team Jatt = new Team(3065, "Jatt", 2015, "Jatt", 0,0,0,0);
        Team Orbit = new Team(1690, "Orbit", 2009, "Binyamina", 0,0,0,0);

//        , "Jat 3065", "GreenBlitz 4590", "Steampunk 1577"
        quale[] quale = new quale[5];
        for (int i = 0; i < 5; i++) {
            quale[i] = new quale("1",0,false,0,0,0,0,0,0);
        }

        Team[] teams = {Orbit, Excalibur, GreenBlitz, SteamPunk, Jatt};

        Map<String, Team> teamsByName = new HashMap<String, Team>();

        for (Team team : teams) {
            teamsByName.put(team.getName(), team);
        }

        return teamsByName;
    }

    public Main(String websiteIntegration) {

    }

    public static void main(String[] args) {
        Map<String, Team> teamsMap = getTeamsMap();
        quale[] quale = new quale[5];
        int b;
        for (int i = 0; i < 5; i++) {
            quale[i] = new quale("1",0,false,0,0,0,0,0,0);
        }
        String[] teamsName = teamsMap.keySet().toArray(new String[0]);
        System.out.println(teamsName);

        JMenu menu, submenu;
        JMenuItem i1, i2, i3, i4, i5;
        // SeparatorExample();  {
        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("Home");
        i1 = new JMenuItem("Go Back");
        i2 = new JMenuItem("Exit");
        menu = new JMenu("Scout");
        i3 = new JMenuItem("Scout now");
        i4 = new JMenuItem("Devices");
        i5 = new JMenuItem("Scout updates");
        menu1.add(i1);
        menu1.addSeparator();
        menu1.add(i2);
        mb.add(menu1);
        menu.add(i4);
        menu.add(i3);
        menu.add(i2);
        menu.addSeparator();
        mb.add(menu);
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFrame Cscout = new JFrame("Computer Scout");
                Cscout.setSize(1400, 1000);
                Cscout.setLayout(null);
                Cscout.setVisible(true);
                JLabel l6 = new JLabel("Which teams are you scouting for?");
                l6.setBounds(550, 90, 600, 50);
                l6.setFont(new Font("assistant Bold", Font.PLAIN, 20));
                l6.setForeground(Color.black);
                JComboBox cb = new JComboBox(teamsName);
                cb.setBounds(640, 150, 130, 20); // set the bounds for the combo box

                ;

                System.out.println(cb.getSelectedItem());
                TextField t1 = new TextField();
                JLabel l7 = new JLabel("assignment number?");
                l7.setBounds(600, 200, 600, 50);
                l7.setFont(new Font("assistant Bold", Font.PLAIN, 20));
                l7.setForeground(Color.black);
                t1.setBounds(640, 260, 130, 20);
                Button d = new Button("Next");
                Cscout.add(l6);
                Cscout.add(cb);
                Cscout.add(l7);
                Cscout.add(t1);
                Cscout.add(d);
                d.setBounds(670, 290, 60, 20);
                d.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int high = 0;
                        final int[] highC = {0};
                        final int[] midC = {0};
                        final int[] mid = {0};
                        final int[] low = {0};
                        final int[] lowc = {0};
                        Cscout.remove(l6);
                        Cscout.remove(cb);
                        Cscout.remove(l7);
                        Cscout.remove(t1);
                        Cscout.remove(d);

                        Cscout.setForeground(Color.white);
                        Cscout.getContentPane().revalidate();
                        Cscout.getContentPane().repaint();
                        ImageIcon icon = new ImageIcon("C:\\Users\\אורי\\IdeaProjects\\Scout\\src\\field.png");
                        JLabel image = new JLabel();
                        image.setIcon(icon);
                        Button b = new Button("Next");
                        b.setBounds(70, 260, 60, 30);
                        image.setBounds(0, 300, 1400, 605); // set the bounds for the combo box
                        JCheckBox c1 = new JCheckBox();
                        c1.setBounds(1185, 695, 10, 10);
                        JCheckBox c2 = new JCheckBox();
                        c2.setBounds(1185, 660, 10, 10);
                        JCheckBox c3 = new JCheckBox();
                        c3.setBounds(1185, 625, 10, 10);
                        JCheckBox c4 = new JCheckBox();
                        c4.setBounds(1185, 590, 10, 10);
                        JCheckBox c5 = new JCheckBox();
                        c5.setBounds(1185, 555, 10, 10);
                        JCheckBox c6 = new JCheckBox();
                        c6.setBounds(1185, 730, 10, 10);
                        JCheckBox c7 = new JCheckBox();
                        c7.setBounds(1185, 765, 10, 10);
                        JCheckBox c8 = new JCheckBox();
                        c8.setBounds(1185, 800, 10, 10);
                        JCheckBox c9 = new JCheckBox();
                        c9.setBounds(1185, 835, 10, 10);
                        JCheckBox c18 = new JCheckBox();
                        c18.setBounds(1160, 800, 10, 10);
                        JCheckBox c11 = new JCheckBox();
                        c11.setBounds(1160, 695, 10, 10);
                        JCheckBox c14 = new JCheckBox();
                        c14.setBounds(1160, 590, 10, 10);
                        JCheckBox c12 = new JCheckBox();
                        c12.setBounds(1160, 660, 10, 10);
                        JCheckBox c13 = new JCheckBox();
                        c13.setBounds(1160, 625, 10, 10);
                        JCheckBox c15 = new JCheckBox();
                        c15.setBounds(1160, 555, 10, 10);
                        JCheckBox c16 = new JCheckBox();
                        c16.setBounds(1160, 730, 10, 10);
                        JCheckBox c17 = new JCheckBox();
                        c17.setBounds(1160, 765, 10, 10);
                        c9.setBounds(1185, 835, 10, 10);
                        JCheckBox c28 = new JCheckBox();
                        c28.setBounds(1135, 800, 10, 10);
                        JCheckBox c21 = new JCheckBox();
                        c21.setBounds(1160, 695, 10, 10);
                        JCheckBox c24 = new JCheckBox();
                        c24.setBounds(1160, 590, 10, 10);
                        JCheckBox c22 = new JCheckBox();
                        c22.setBounds(1160, 660, 10, 10);
                        JCheckBox c23 = new JCheckBox();
                        c23.setBounds(1160, 625, 10, 10);
                        JCheckBox c25 = new JCheckBox();
                        c25.setBounds(1160, 555, 10, 10);
                        JCheckBox c26 = new JCheckBox();
                        c26.setBounds(1160, 730, 10, 10);
                        JCheckBox c27 = new JCheckBox();
                        c27.setBounds(1160, 765, 10, 10);

                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int high = 0;
                                if (c2.isSelected()) {
                                    high = high + 1;
                                }
                                if (c3.isSelected()) {
                                    high = high + 1;
                                }
                                if (c5.isSelected()) {
                                    high = high + 1;
                                }
                                if (c6.isSelected()) {
                                    high = high + 1;
                                }
                                if (c7.isSelected()) {
                                    high = high + 1;
                                }
                                if (c9.isSelected()) {
                                    high = high + 1;
                                }
                                if (c8.isSelected()) {
                                    highC[0] = highC[0] + 1;
                                }
                                if (c1.isSelected()) {
                                    highC[0] = highC[0] + 1;
                                }
                                if (c4.isSelected()) {
                                    highC[0] = highC[0] + 1;
                                }
                                if (c11.isSelected()) {
                                    midC[0] = midC[0] + 1;
                                }
                                if (c14.isSelected()) {
                                    midC[0] = midC[0] + 1;
                                }
                                if (c18.isSelected()) {
                                    midC[0] = midC[0] + 1;
                                }
                                if (c12.isSelected()) {
                                    mid[0] = mid[0] + 1;
                                }
                                if (c13.isSelected()) {
                                    mid[0] = mid[0] + 1;
                                }
                                if (c15.isSelected()) {
                                    mid[0] = mid[0] + 1;
                                }
                                if (c16.isSelected()) {
                                    mid[0] = mid[0] + 1;
                                }
                                if (c17.isSelected()) {
                                    mid[0] = mid[0] + 1;
                                }
                                if (c22.isSelected()) {
                                    low[0] = low[0] + 1;
                                }
                                if (c23.isSelected()) {
                                    low[0] = low[0] + 1;
                                }
                                if (c25.isSelected()) {
                                    low[0] = low[0] + 1;
                                }
                                if (c26.isSelected()) {
                                    low[0] = low[0] + 1;
                                }
                                if (c27.isSelected()) {
                                    low[0] = low[0] + 1;
                                }
                                if (c28.isSelected()) {
                                    lowc[0] = lowc[0] + 1;
                                }
                                if (c24.isSelected()) {
                                    lowc[0] = lowc[0] + 1;
                                }
                                if (c21.isSelected()) {
                                    lowc[0] = lowc[0] + 1;
                                }
                                String b = t1.getText();
                                int a=Integer.parseInt(b);
                                System.out.println(b);
                                quale[] quale = new quale[5];
                                for (int i = 0; i < 5; i++) {
                                    quale[i] = new quale("1",0,false,0,0,0,0,0,0);
                                }
                                Object temp1 = cb.getSelectedItem();
                                if (temp1 != null) {
                                    Team selectedTeam = teamsMap.get(temp1.toString());
                                    selectedTeam.setCounos_num_high(high);
                                    selectedTeam.setCube_high(highC[0]);
                                    selectedTeam.setCube_littel(midC[0]);
                                    selectedTeam.setCounos_littel(midC[0]);
                                    selectedTeam.setCube_low(lowc[0]);
                                    selectedTeam.setCube_low(low[0]);
                                    quale[a].setCube_high(selectedTeam.getCube_high());
                                    quale[a].setCounos_num_high(selectedTeam.getCounos_num_high());
                                    quale[a].setCubeLittel(selectedTeam.getCube_littel());
                                    quale[a].setConos_littel(selectedTeam.getCounos_littel());
                                    quale[a].setCube_low(selectedTeam.getCube_low());
                                    quale[a].setLow(selectedTeam.getLow());
                                }
                                System.out.println(quale[a].getCube_high());
                            }

                        });

                        Cscout.getContentPane().revalidate();
                        Cscout.getContentPane().repaint();
                        Cscout.add(c28);
                        Cscout.add(c27);
                        Cscout.add(c26);
                        Cscout.add(c25);
                        Cscout.add(c24);
                        Cscout.add(c23);
                        Cscout.add(c22);
                        Cscout.add(c21);
                        Cscout.add(c6);
                        Cscout.add(c7);
                        Cscout.add(c8);
                        Cscout.add(c9);
                        Cscout.add(c18);
                        Cscout.add(c11);
                        Cscout.add(c14);
                        Cscout.add(c12);
                        Cscout.add(c13);
                        Cscout.add(c15);
                        Cscout.add(c16);
                        Cscout.add(c17);
                        Cscout.add(c5);
                        Cscout.add(c4);
                        Cscout.add(c3);
                        Cscout.add(c2);
                        Cscout.add(c1);
                        Cscout.add(image);
                        Cscout.add(b);


                    }
                });
            }

        });
//            i3.addActionListener();
//            i4.addActionListener();


//            JFrame f = new JFrame("Login");
//        JPasswordField value = new JPasswordField();
//        JLabel l3 = new JLabel("Username:");
//        l3.setBounds(20, 50, 80, 30);
//        TextField t1 = new TextField();
//        t1.setBounds(100, 50, 100, 30);
//        JLabel l1 = new JLabel("Password:");
//        l1.setBounds(20, 100, 80, 30);
//        JPasswordField A1 = new JPasswordField();
//        A1.setBounds(100, 100, 100, 30);
//        Button b = new Button("Log-in");
//        b.setBounds(120, 150, 60, 30);
//        JLabel l5 = new JLabel();
//        l5.setBounds(20, 200, 200, 30);
//        f.add(t1);
//        f.add(l3);
//        f.add(A1);
//        f.add(l1);
//        f.add(b);
//        f.add(l5);
//        f.setSize(300, 300);
//        f.setLayout(null);
//        f.setVisible(true);
//        t1.addActionListener(new ActionListener() {         //end of login
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (t1.getText().equals("Excalibur") && new String(A1.getPassword()).equals("6738")) {
//                    l5.setText("Welcome!");
//                    f.setVisible(false);
        JFrame h = new JFrame("Scout Excalibur");
        JLabel l6 = new JLabel("Good evening Excalibur!");
        l6.setFont(new Font("assistant", Font.PLAIN, 24));
        l6.setBounds(50, 10, 300, 100);
        ImageIcon icon = new ImageIcon("C:\\Users\\אורי\\IdeaProjects\\Scout\\src\\TvsT.png");
        JLabel image = new JLabel();
        image.setIcon(icon);
        image.setBounds(130, 40, 700, 500); // set the bounds for the combo box
        ImageIcon icon1 = new ImageIcon("C:\\Users\\אורי\\IdeaProjects\\Scout\\src\\update.png");
        JLabel image1 = new JLabel();
        image1.setIcon(icon1);
        image1.setBounds(800, 40, 700, 500); // set the bounds for the combo box
        h.add(l6);
        h.add(image);
        h.add(image1);
        h.setLayout(null);
        h.setVisible(true);
        h.setJMenuBar(mb);
        h.setJMenuBar(mb);
        h.setSize(1920, 1100);
        h.setLayout(null);
        h.setVisible(true);

        image.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                h.getContentPane().remove(image);
                h.remove(image1);
                h.getContentPane().revalidate();
                h.getContentPane().repaint();
                l6.setText("Set your scout teams:");
                l6.setBounds(750, 90, 600, 50);
                l6.setFont(new Font("assistant ExtraBold", Font.PLAIN, 40));
                l6.setForeground(Color.getHSBColor(-140, 99, -55));
                h.setSize(1920, 1100);
                JComboBox cb = new JComboBox(teamsName);
                cb.setBounds(900, 150, 130, 20); // set the bounds for the combo box
                JComboBox cb1 = new JComboBox(teamsName);
                cb1.setBounds(900, 190, 130, 20); // set the bounds for the combo box
                Button d = new Button("Start");
                d.setBounds(930, 220, 60, 20);
                //h.add(image);
                h.add(l6);
                h.add(cb);
                h.add(cb1);
                h.setForeground(Color.getHSBColor(-140, 99, -55));
                h.add(d);
//                            h.add(image);


            }
        });
        image1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                h.getContentPane().remove(image1);
                h.remove(image);
                h.getContentPane().revalidate();
                h.getContentPane().repaint();
                JComboBox cb = new JComboBox(teamsName);
                cb.setBounds(1600, 90, 130, 20); // set the bounds for the combo box
                h.add(l6);
                h.add(cb);
                TextField t2 = new TextField();
                t2.setBounds(1450, 90, 100, 20);
                h.setForeground(Color.getHSBColor(-140, 99, -55));
                Button b = new Button("Start");
                b.setBounds(1600, 120, 130, 20);
                h.add(b); h.add(t2);
                    JLabel l2 = new JLabel();
                    JLabel l3 = new JLabel();
                    JLabel l4 = new JLabel();
                    JLabel l5 = new JLabel();
                    JLabel l6 = new JLabel();
                    JLabel l7 = new JLabel();
                    JLabel l12 = new JLabel();
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            h.add(l5); h.add(l4); h.add(l3); h.add(l2);
                            String v = t2.getText();
                            int j=Integer.parseInt(v);
                            System.out.println(v);
                            Object temp1 = cb.getSelectedItem();
                            if (temp1 != null) {
                            Team selectedTeam = teamsMap.get(temp1.toString());
                            System.out.println(selectedTeam);
                            selectedTeam.setCounos_num_high(1);
                            l2.setText(selectedTeam.getName() + " Counos High last game: " + selectedTeam.counos_num_high);
                            l2.setBounds(150, 100, 250, 100);
                            l2.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l3.setText(selectedTeam.getName() + " Cube High last game: " + selectedTeam.cube_high);
                            l3.setBounds(150, 120, 250, 100);
                            l3.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l4.setText(selectedTeam.getName() + " Counos Mid last game: " + selectedTeam.cube_littel);
                            l4.setBounds(150, 140, 250, 100);
                            l4.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l5.setText(selectedTeam.getName() + " Counos Mid last game: " + selectedTeam.counos_littel);
                            l5.setBounds(150, 160, 250, 100);
                            l5.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l6.setText(selectedTeam.getName() + "Counos Mid last game: " + selectedTeam.low);
                            l6.setBounds(150, 180, 250, 100);
                            l6.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l7.setText(selectedTeam.getName() + "Cube Mid last game: " + selectedTeam.low);
                            l7.setBounds(150, 200, 250, 100);
                            l7.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            l12.setText(selectedTeam.getName() + " Cones for height in the selected game: " +quale[j].getCube_high());
                            l12.setBounds(500, 100, 350, 100);
                            l12.setFont(new Font("assistant Bold", Font.PLAIN, 15));
                            h.add(l5); h.add(l4); h.add(l3); h.add(l2); h.add(l6); h.add(l7); h.add(l12);
                            System.out.println(quale[j].getCube_high());
                            }
                        }
                    });

                };

            });
        }


        ;};


//                } else {
//                    l5.setText("Invalid username or password");




//}

//        });
//        return;
//
//    }
//}}}