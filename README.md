# Email reader application

This Java application uses the Jakarta Mail API to connect to an IMAP email server and read messages from the inbox. It allows for a basic setup to access the server securely using SSL and print the subject of each message retrieved.

## Features

- Connects to an IMAP email server using SSL.
- Reads and lists the subjects of all messages in the inbox.
- Utilizes the Jakarta Mail API for managing email connectivity.

## Prerequisites

- Java 17
- Maven 4.0.0+
- An IMAP email server (such as Gmail) with an active account for testing.

## Dependencies

The application requires the following dependencies, specified in `pom.xml`:

- **Jakarta Mail** (2.0.1): For handling IMAP email protocols.
- **Jakarta Activation API** (2.0.1): For data handling and MIME type support, needed by the Jakarta Mail API.

## Project Structure

- **`SenderEmail` Class**: The main class for managing the email connection and retrieving messages.
  - **Methods**:
    - `init()`: Configures the IMAP connection settings (host, port, protocol, SSL).
    - `main()`: Connects to the email server and retrieves and displays message subjects from the inbox.

## Sample Output

If the connection is successful, the program will output:

```plaintext
Connected to the IMAP server
Subject: First email subject
Subject: Second email subject
...
```

## Configuration

- **`pom.xml`**: Defines project dependencies and builds properties.
- **IMAP Server Configuration**: Defaulted to Gmail (`imap.gmail.com`), SSL enabled, port `993`.

## Troubleshooting

- **Provider Not Found**: Ensure Jakarta Mail and Activation dependencies are installed.
- **Messaging Exception**: Check email credentials, and make sure IMAP access is enabled in your email provider’s settings.