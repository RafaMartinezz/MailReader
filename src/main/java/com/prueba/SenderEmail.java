package com.prueba;

import java.util.Properties;
import jakarta.mail.*;

/**
 * SenderEmail class encapsulates functionality to connect to an email server
 * using IMAP
 * and read email messages. Uses Jakarta Mail for managing connections and
 * accessing messages.
 */
public class SenderEmail {
    /**
     * Configuration properties for the IMAP session.
     */
    private final Properties properties = new Properties();

    /**
     * Mail session used to connect and operate over the IMAP server.
     */
    private Session session;

    /**
     * Initializes the IMAP session properties for secure SSL connection to an IMAP
     * server.
     * Configures the protocol, host, port, and SSL enablement.
     */
    private void init() {
        // Sets up IMAP protocol with necessary SSL connection details
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.host", "imap.gmail.com");
        properties.put("mail.imap.port", 993); // Standard port for IMAP over SSL
        properties.put("mail.imap.ssl.enable", "true"); // Enables SSL

        // Creates the session with the configured properties
        session = Session.getDefaultInstance(properties);
    }

    /**
     * Main method that initiates the IMAP connection and reads emails from the
     * INBOX.
     * Prints the subjects of read messages and handles specific provider and
     * messaging exceptions.
     * 
     * @param args Command line arguments (unused).
     */
    public static void main(String args[]) {
        SenderEmail sender = new SenderEmail();

        sender.init(); // Initializes the IMAP connection settings

        Store store;
        try {
            // Obtains the IMAP Store and connects using user credentials
            store = sender.session.getStore();
            store.connect("xxxxxxxx", "xxxxxxx"); // Replace with actual email credentials
            System.out.println("Connected to the IMAP server");

            // Accesses and opens the INBOX folder in read-only mode
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Retrieves and displays the subject of each message in INBOX
            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                System.out.println(message.getSubject());
            }

            // Closes the folder and the store to release resources
            inbox.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.out.println("Provider not found error");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Messaging error");
        }
    }
}
