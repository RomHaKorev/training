
class UserService:
    def __init__(self, smtplogin):
        self.smtplogin = smtplogin
        self._database = Database.getInstance()

    def register(self, email, password):
        if not email.contains("@"):
            raise "Email is not an email!"
        user = User(email, password);
        self._database.save(user);
        smtpClient = SmtpClient.connect(Smtp.getConf(), self.smtplogin);
        smtpClient.send(MailMessage("mysite@nowhere.com", email, subject = "HEllo fool!")
