public class UserService {
  private final String smtplogin;
  private Database _database;

  public UserService(String smtplogin) {
    this.smtplogin = smtplogin;
    _database = Database.getInstance();
  }

  public void register(String email, String password) {
    if (!email.contains("@"))
      throw new ValidationException("Email is not an email!");
    User user = new User(email, password);
    _database.save(user);
    SmtpClient _smtpClient = SmtpClient.connect(Smtp.getConf(), smtplogin);
    _smtpClient.send(new MailMessage("mysite@nowhere.com", email) {{
      subject = "HEllo fool!";
    }});
  }
}
