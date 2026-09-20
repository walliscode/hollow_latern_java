package voxel;

import javafx.scene.paint.Color;

/**
 * Represents a three-dimensional array of voxels.
 *
 * <p>
 * Each voxel stores a {@link Color}. Internally, the voxels are stored in a
 * one-dimensional array. Three-dimensional coordinates are converted into a
 * one-dimensional index using the configured width, height, and depth.
 * </p>
 */
public class VoxelArray {

  /**
   * Total number of voxels along the x-axis.
   */
  private final int width;

  /**
   * Total number of voxels along the y-axis.
   */
  private final int height;

  /**
   * Total number of voxels along the z-axis.
   */
  private final int depth;

  /**
   * Flat storage array containing the color of every voxel.
   */
  private final Color[] voxels;

  /**
   * Constructs a VoxelArray with the specified dimensions.
   *
   * <p>
   * All voxels are initially set to {@code null} until a color is assigned.
   * A dimension of zero is allowed, but negative dimensions are rejected.
   * </p>
   *
   * @param width  number of voxels along the x-axis
   * @param height number of voxels along the y-axis
   * @param depth  number of voxels along the z-axis
   * @throws IllegalArgumentException if any dimension is negative
   */
  public VoxelArray(int width, int height, int depth) {
    validateDimensions(width, height, depth);

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.voxels = new Color[width * height * depth];
  }

  /**
   * Returns the width of this voxel array.
   *
   * @return the number of voxels along the x-axis
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns the height of this voxel array.
   *
   * @return the number of voxels along the y-axis
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns the depth of this voxel array.
   *
   * @return the number of voxels along the z-axis
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Calculates the flat-array index for a three-dimensional coordinate.
   *
   * @param x x-coordinate of the voxel
   * @param y y-coordinate of the voxel
   * @param z z-coordinate of the voxel
   * @return the corresponding index in the internal flat array
   * @throws IndexOutOfBoundsException if the coordinates are outside the array
   */
  private int getIndex(int x, int y, int z) {
    validateCoordinates(x, y, z);
    return x + y * width + z * width * height;
  }

  /**
   * Assigns a color to one voxel.
   *
   * @param x     x-coordinate of the voxel
   * @param y     y-coordinate of the voxel
   * @param z     z-coordinate of the voxel
   * @param color color to assign to the voxel
   * @throws IndexOutOfBoundsException if the coordinates are outside the array
   */
  public void setVoxel(int x, int y, int z, Color color) {
    voxels[getIndex(x, y, z)] = color;
  }

  /**
   * Returns the color stored at one voxel.
   *
   * @param x x-coordinate of the voxel
   * @param y y-coordinate of the voxel
   * @param z z-coordinate of the voxel
   * @return the color stored at the requested voxel, or {@code null} if no
   *         color has been assigned
   * @throws IndexOutOfBoundsException if the coordinates are outside the array
   */
  public Color getVoxel(int x, int y, int z) {
    return voxels[getIndex(x, y, z)];
  }

  /**
   * Assigns the same color to every voxel in this array.
   *
   * @param color color to assign to every voxel
   */
  public void setAllVoxelsColor(Color color) {
    for (int index = 0; index < voxels.length; index++) {
      voxels[index] = color;
    }
  }

  /**
   * Validates the dimensions supplied to the constructor.
   *
   * @param width  width to validate
   * @param height height to validate
   * @param depth  depth to validate
   * @throws IllegalArgumentException if any dimension is negative
   */
  private static void validateDimensions(int width, int height, int depth) {
    if (width < 0 || height < 0 || depth < 0) {
      throw new IllegalArgumentException(
          "Voxel dimensions cannot be negative");
    }
  }

  /**
   * Validates coordinates against this array's dimensions.
   *
   * @param x x-coordinate to validate
   * @param y y-coordinate to validate
   * @param z z-coordinate to validate
   * @throws IndexOutOfBoundsException if any coordinate is outside the array
   */
  private void validateCoordinates(int x, int y, int z) {
    if (x < 0 || x >= width
        || y < 0 || y >= height
        || z < 0 || z >= depth) {
      throw new IndexOutOfBoundsException(
          "Voxel coordinates are outside the array bounds");
    }
  }
}
