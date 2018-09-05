public interface MultiFunctionPrinter {
  void fax(Page page, PhoneNumber number);
  void scan(Page page, EmailAddress address);
  void call(PhoneNumber number);
  void copy(Page page, int number);
  void print(Page page);
}
