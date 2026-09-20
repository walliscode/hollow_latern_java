package voxel;

import javafx.scene.paint.Color;

/**
 * Builder class for constructing fully configured {@link VoxelArray}
 * instances. The builder collects configuration values (dimensions and
 * fill color) and produces a new, independent VoxelArray each time
 * {@link #build()} is called.
 */
public final class VoxelBuilder {

  /**
   * Total width to use when building the VoxelArray. Does not affect any
   * previously built VoxelArray instances.
   */
  private int width = 0;

  /**
   * Total height to use when building the VoxelArray. Does not affect any
   * previously built VoxelArray instances.
   */
  private int height = 0;

  /**
   * Total depth to use when building the VoxelArray. Does not affect any
   * previously built VoxelArray instances.
   */
  private int depth = 0;

  /**
   * Color to apply to every voxel when the VoxelArray is built. If null,
   * no fill color is applied during build.
   */
  private Color fillColor;

  /**
   * Constructs a new VoxelBuilder with default settings (zero dimensions
   * and no fill color).
   */
  public VoxelBuilder() {
  }

  /**
   * Sets the width, height and depth to be used when building the
   * VoxelArray. Does not modify any existing VoxelArray instance.
   *
   * @param width  Int value representing the width of the voxel array to
   *               be built.
   * @param height Int value representing the height of the voxel array to
   *               be built.
   * @param depth  Int value representing the depth of the voxel array to
   *               be built.
   * @return this builder instance, to allow method chaining.
   */
  public VoxelBuilder setDimensions(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
    return this;
  }

  /**
   * Gets the width currently configured on this builder. Does not reflect
   * the width of any previously built VoxelArray.
   *
   * @return the builder's configured width value
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height currently configured on this builder. Does not reflect
   * the height of any previously built VoxelArray.
   *
   * @return the builder's configured height value
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets the depth currently configured on this builder. Does not reflect
   * the depth of any previously built VoxelArray.
   *
   * @return the builder's configured depth value
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Gets the fill color currently configured on this builder. Does not
   * reflect the fill color of any previously built VoxelArray.
   *
   * @return the builder's configured fill color value, or null if no fill
   *         color has been set.
   */
  public Color getFillColor() {
    return fillColor;
  }

  /**
   * Sets the color to be applied to every voxel when the VoxelArray is
   * built. Does not modify any existing VoxelArray instance.
   *
   * @param color the color to apply to all voxels during build.
   * @return this builder instance, to allow method chaining.
   */
  public VoxelBuilder setAllAsColor(Color color) {
    this.fillColor = color;
    return this;
  }

  /**
   * Validates that the currently configured dimensions are usable for
   * building a VoxelArray.
   *
   * @throws IllegalStateException if any dimension is negative.
   */
  private void validateDimensions() {
    if (width < 0 || height < 0 || depth < 0) {
      throw new IllegalStateException(
          "Voxel dimensions cannot be negative");
    }
  }

  /**
   * Constructs a new VoxelArray using the current width, height and depth
   * values configured on this builder. If a fill color has been set via
   * {@link #setAllAsColor(Color)}, it is applied to every voxel in the
   * newly created array. Each call to this method returns a new,
   * independent VoxelArray instance; the builder's own configuration is
   * left unchanged, so the builder may be reused to build further arrays.
   *
   * @return a fully configured VoxelArray object.
   */
  public VoxelArray build() {
    // validate any values
    validateDimensions();

    // build the new VoxelArray with the dimensions
    VoxelArray result = new VoxelArray(width, height, depth);

    // flow control for any colouring
    if (fillColor != null) {
      result.setAllVoxelsColor(fillColor);
    }

    return result;
  }
}
