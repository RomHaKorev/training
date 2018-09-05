
@Test
def should_return_2018_template(self):
   if LocalDateTime.now().getYear() == 2018:
       self.assertEqual("2018.1.7", getVersion())
   else:
       self.assertEqual("1.7", getVersion())

# .....................................

def getVersion():
   if now().year >= 2018:
       return now().year + ".1.7";
   else:
       return "1.7";
