
class Rectangle:
    def __init__(self, width, height):
        self.width = 0
        self.height = 0

    def set_dimension(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        return self.width * self.height


class Square(Rectangle):
  def set_dimension(self, width, height):
      if width != height:
          raise "Invalid argument"
      super(self).set_dimension(width, width)

# ---

def enlarge(rectangle):
    height = rectangle.height;
    rectangle.set_dimension(height * 3, height)
