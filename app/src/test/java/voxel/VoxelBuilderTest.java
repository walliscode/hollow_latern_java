package voxel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link VoxelBuilder} class. These tests verify that a
 * VoxelBuilder stores its configuration correctly and creates independent
 * VoxelArray objects with the configured dimensions.
 */
public class VoxelBuilderTest {

  /**
   * Tests that the VoxelBuilder initializes with zero dimensions.
   */
  @Test
  public void voxelBuilderInitializesWithDefaultDimensions() {
    VoxelBuilder builder = new VoxelBuilder();

    assertEquals(0, builder.getWidth(), "Initial width should be 0");
    assertEquals(0, builder.getHeight(), "Initial height should be 0");
    assertEquals(0, builder.getDepth(), "Initial depth should be 0");
  }

  /**
   * Tests that setDimension configures the width, height, and depth values
   * stored by the builder.
   */
  @Test
  public void setDimensionConfiguresBuilderDimensions() {
    VoxelBuilder builder = new VoxelBuilder();

    builder.setDimensions(10, 5, 3);

    assertEquals(10, builder.getWidth(), "Builder width should be 10");
    assertEquals(5, builder.getHeight(), "Builder height should be 5");
    assertEquals(3, builder.getDepth(), "Builder depth should be 3");
  }

  @Test
  public void setAllAsColorConfiguresBuilderFillColor() {
    VoxelBuilder builder = new VoxelBuilder();
    builder.setAllAsColor(javafx.scene.paint.Color.RED);
    assertEquals(javafx.scene.paint.Color.RED, builder.getFillColor(),
        "Builder fill color should be RED");
  }

  /**
   * Tests that build creates a VoxelArray with dimensions matching the
   * dimensions configured on the builder.
   */
  @Test
  public void buildCreatesVoxelArrayWithCorrectDimensions() {
    VoxelBuilder builder = new VoxelBuilder()
        .setDimensions(4, 5, 6);

    VoxelArray voxelArray = builder.build();

    assertEquals(4, voxelArray.getWidth(), "VoxelArray width should be 4");
    assertEquals(5, voxelArray.getHeight(), "VoxelArray height should be 5");
    assertEquals(6, voxelArray.getDepth(), "VoxelArray depth should be 6");
  }

  /**
   * Tests that build does not reset the builder configuration, allowing the
   * builder to be reused to create another VoxelArray with the same settings.
   */
  @Test
  public void buildPreservesBuilderState() {
    VoxelBuilder builder = new VoxelBuilder()
        .setDimensions(4, 5, 6);

    builder.build();

    assertEquals(4, builder.getWidth(), "Builder width should remain 4");
    assertEquals(5, builder.getHeight(), "Builder height should remain 5");
    assertEquals(6, builder.getDepth(), "Builder depth should remain 6");
  }

  /**
   * Tests that each call to build creates a separate VoxelArray object rather
   * than returning the same object reference.
   */
  @Test
  public void buildCreatesIndependentVoxelArrays() {
    VoxelBuilder builder = new VoxelBuilder()
        .setDimensions(4, 5, 6);

    VoxelArray firstVoxelArray = builder.build();
    VoxelArray secondVoxelArray = builder.build();

    assertNotSame(firstVoxelArray, secondVoxelArray,
        "Each build call should create a new VoxelArray");

    assertEquals(4, firstVoxelArray.getWidth(), "First VoxelArray width should be 4");
    assertEquals(5, firstVoxelArray.getHeight(), "First VoxelArray height should be 5");
    assertEquals(6, firstVoxelArray.getDepth(), "First VoxelArray depth should be 6");

    assertEquals(4, secondVoxelArray.getWidth(), "Second VoxelArray width should be 4");
    assertEquals(5, secondVoxelArray.getHeight(), "Second VoxelArray height should be 5");
    assertEquals(6, secondVoxelArray.getDepth(), "Second VoxelArray depth should be 6");
  }
}
