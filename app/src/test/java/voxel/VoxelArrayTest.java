package voxel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

/**
 * Tests the behavior of the {@link VoxelArray} class.
 */
public class VoxelArrayTest {

  /**
   * Tests that the constructor stores the supplied dimensions.
   */
  @Test
  public void constructorStoresDimensions() {
    VoxelArray voxelArray = new VoxelArray(4, 5, 6);

    assertEquals(4, voxelArray.getWidth());
    assertEquals(5, voxelArray.getHeight());
    assertEquals(6, voxelArray.getDepth());
  }

  /**
   * Tests that voxels are initially unassigned.
   */
  @Test
  public void voxelsInitiallyHaveNoColor() {
    VoxelArray voxelArray = new VoxelArray(2, 2, 2);

    assertNull(voxelArray.getVoxel(0, 0, 0));
    assertNull(voxelArray.getVoxel(1, 1, 1));
  }

  /**
   * Tests that a color can be assigned to and retrieved from one voxel.
   */
  @Test
  public void setVoxelAssignsColorToVoxel() {
    VoxelArray voxelArray = new VoxelArray(2, 2, 2);

    voxelArray.setVoxel(1, 0, 1, Color.RED);

    assertEquals(Color.RED, voxelArray.getVoxel(1, 0, 1));
  }

  /**
   * Tests that setting one voxel does not change another voxel.
   */
  @Test
  public void setVoxelOnlyChangesSelectedVoxel() {
    VoxelArray voxelArray = new VoxelArray(2, 2, 2);

    voxelArray.setVoxel(0, 0, 0, Color.BLUE);

    assertEquals(Color.BLUE, voxelArray.getVoxel(0, 0, 0));
    assertNull(voxelArray.getVoxel(1, 0, 0));
  }

  /**
   * Tests that setAllVoxelsColor assigns the supplied color to every voxel.
   */
  @Test
  public void setAllVoxelsColorAssignsColorToEveryVoxel() {
    VoxelArray voxelArray = new VoxelArray(2, 2, 2);

    voxelArray.setAllVoxelsColor(Color.GREEN);

    for (int x = 0; x < voxelArray.getWidth(); x++) {
      for (int y = 0; y < voxelArray.getHeight(); y++) {
        for (int z = 0; z < voxelArray.getDepth(); z++) {
          assertEquals(Color.GREEN, voxelArray.getVoxel(x, y, z));
        }
      }
    }
  }

  /**
   * Tests that a previously assigned voxel color can be replaced.
   */
  @Test
  public void setVoxelReplacesExistingColor() {
    VoxelArray voxelArray = new VoxelArray(1, 1, 1);

    voxelArray.setVoxel(0, 0, 0, Color.RED);
    voxelArray.setVoxel(0, 0, 0, Color.YELLOW);

    assertEquals(Color.YELLOW, voxelArray.getVoxel(0, 0, 0));
  }

  /**
   * Tests that negative dimensions are rejected.
   */
  @Test
  public void constructorRejectsNegativeDimensions() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new VoxelArray(-1, 2, 3));

    assertThrows(
        IllegalArgumentException.class,
        () -> new VoxelArray(1, -2, 3));

    assertThrows(
        IllegalArgumentException.class,
        () -> new VoxelArray(1, 2, -3));
  }

  /**
   * Tests that coordinates below zero are rejected.
   */
  @Test
  public void voxelMethodsRejectNegativeCoordinates() {
    VoxelArray voxelArray = new VoxelArray(2, 2, 2);

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.getVoxel(-1, 0, 0));

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.setVoxel(0, -1, 0, Color.RED));

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.getVoxel(0, 0, -1));
  }

  /**
   * Tests that coordinates equal to or greater than a dimension are rejected.
   */
  @Test
  public void voxelMethodsRejectCoordinatesOutsideDimensions() {
    VoxelArray voxelArray = new VoxelArray(2, 3, 4);

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.getVoxel(2, 0, 0));

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.getVoxel(0, 3, 0));

    assertThrows(
        IndexOutOfBoundsException.class,
        () -> voxelArray.setVoxel(0, 0, 4, Color.RED));
  }

  /**
   * Tests that a zero-sized array can be created and reports its dimensions.
   */
  @Test
  public void zeroSizedArrayIsAllowed() {
    VoxelArray voxelArray = new VoxelArray(0, 0, 0);

    assertEquals(0, voxelArray.getWidth());
    assertEquals(0, voxelArray.getHeight());
    assertEquals(0, voxelArray.getDepth());
  }
}
