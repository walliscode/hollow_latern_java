package voxel;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HollowVoxelArrayTest {

  /**
   * A 2 x 2 x 2 cube of white voxels
   */
  private final Color[] BASIC_CUBE_ONE = new Color[] { Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,
      Color.WHITE,
      Color.WHITE, Color.WHITE };

  /**
   * Test that the basic cube is as designed
   */
  @Test
  public void testBasicCubeone() {

    assertEquals(8, BASIC_CUBE_ONE.length);
    for (Color voxel : BASIC_CUBE_ONE) {
      assertEquals(Color.WHITE, voxel);
    }
  }

}
