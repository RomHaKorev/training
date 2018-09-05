public class Rectangle {
  private int width, height;
  public void setDimension(int width, int height) {
    this.width = width;
    this.height = height;
  }
  public int area() {
    return width * height;
  }
}

public class Square extends Rectangle {
  @Override
  public void setDimension(int width, int height) {
    if (width != height)
      throw new IllegalArgumentException();
    super.setDimension(width, width);
  }
}

// ---

public int enlarge(Rectangle rectangle) {
  int height = rectangle.height;
  rectangle.setDimension(height * 3, height)
}
