package ChatAmizade;

import chat.client.ChatClient;
import chat.client.MessageListener;
import chat.common.CommunicationException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatAmizade extends JFrame {

    //DEFINE AS VIEWS PARA ALTERNAR ENTRE JANELAS
    private static final String LOGIN_VIEW = "LOGIN_VIEW";
    private static final String CHAT_VIEW = "CHAT_VIEW";

    //COMPONENTES
    private JTextArea display = new JTextArea(20,30);
    private JTextField input = new JTextField(25);
    private JButton send = new JButton("Enviar");

    //
    private JTextField nickname = new JTextField(23);
    private JTextField hostname = new JTextField(23);
    private JTextField port = new JTextField(23);
    private JButton connect = new JButton("Connect");

    private JPanel loginPanel = new JPanel();
    private JPanel chatPanel = new JPanel();

    private JPanel cards = new JPanel();

    private ChatClient client;

    public ChatAmizade(){
        setSize(800,700);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Client de Chat");
        addWindowListener(new CloseListener());
        cards.setLayout(new CardLayout());
        add(cards);
        makeLoginView();
        makeChatView();
        showLoginView();

    }

    private void makeChatView (){
        display.setLineWrap(true);
        display.setEditable(false);
        display.setAutoscrolls(true);

        JScrollPane displayPane = new JScrollPane(display, 
               JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        displayPane.setAutoscrolls(true);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(input);
        inputPanel.add(send);
        
        chatPanel.add(displayPane);
        chatPanel.add(inputPanel, BorderLayout.PAGE_END);
//
//        add(displayPane);
//        add(inputPanel, BorderLayout.PAGE_END);

        SendListener listener = new SendListener();
        input.addActionListener(listener);
        send.addActionListener(listener);

        cards.add(CHAT_VIEW, chatPanel);
    }

    private void makeLoginView (){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(3,1,5,5));
        
        labels.add(new JLabel("Apelido: "));
        labels.add(new JLabel("IP: "));
        labels.add(new JLabel("Porta: "));
        
        p.add(labels, BorderLayout.LINE_START);
        
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(3,1,5,5));
        
        fields.add(nickname);
        fields.add(hostname);
        fields.add(port);
        
        p.add(fields, BorderLayout.CENTER);
        
        loginPanel.add(p, BorderLayout.CENTER);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        connect.addActionListener(new LoginListener());
        buttons.add(connect);
        
        loginPanel.add(buttons, BorderLayout.PAGE_END);
        
        cards.add(LOGIN_VIEW, loginPanel);
    }

    private class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            client = new ChatClient();
            
            String host = hostname.getText().trim();
            int porta = Integer.valueOf(port.getText());
            String nick = nickname.getText().trim();
            
            try {
                client.connect(host, porta, nick);
            } catch (CommunicationException ex) {
                ex.printStackTrace();
            }
            client.addMessageListener(new MsgListener());
            showChatView();
        }
        
    }

    private void showLoginView(){
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, LOGIN_VIEW);
        setSize(370,180);
    }

    private void showChatView(){
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, CHAT_VIEW);
        setSize(400,400);
    }

    private class SendListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!"".equals((input.getText()))){
                try {
                    client.send(input.getText());
                } catch (CommunicationException ex) {
                    ex.printStackTrace();
                }
                input.setText("");
                input.requestFocus();
            }
        }
    }

    private class MsgListener implements MessageListener{

        @Override
        public void messageReceived(String string) {
                display.append(string);
                display.append("\n");
                display.setCaretPosition(display.getText().length() - 1);
        }
    }
    
    private class CloseListener extends WindowAdapter {
        
        @Override
        public void windowClosing(WindowEvent e) {
            if ( client != null ) {
                try {
                    client.close();
                } catch (CommunicationException ex) {
                    ex.printStackTrace();
                }
            }
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        ChatAmizade client = new ChatAmizade();
        client.setVisible(true);
    }
}
