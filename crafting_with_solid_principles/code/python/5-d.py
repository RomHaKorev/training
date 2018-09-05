class OrderProcessor:
    def calculate_total(self, order, cnx):
        itemTotal = order.getItemTotal()
        discountAmount = DiscountCalculator.calculateDiscount(order)
        taxAmount = 0.0
        if order.getCountry() == US:
            taxAmount = self.findTaxAmount(order, cnx)
        elif order.getCountry() == UK:
            taxAmount = self.findVatAmount(order, cnx)
        total = itemTotal - discountAmount + taxAmount
        return total
  def findVatAmount(self, order, cnx):
      r = Resources()
      try:
          statement = r.push(cnx.prepareStatement( "select amount from vat where country=?" ))
          statement.setString(1, order.getCountry().name())
          resultSet = r.push(statement.executeQuery())
          return resultSet.getDouble(1)
      finally:
          r.dispose()

  def findTaxAmount(order, cnx):
    # ...
