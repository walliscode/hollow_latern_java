package voxel;

import javafx.scene.paint.Color;

/**
 * stores a 3D array of voxels, where each voxel is represented by a Color
 * object. The array is stored as a flat array, with the index of each voxel
 * calculated based on its 3D coordinates. The class provides methods for
 * setting and getting the color of individual voxels, as well as for
 * calculating the index of a voxel based on its coordinates.
 *
 */
public class VoxelArray {

  /**
   * Flat array of voxels, where each voxel is represented by a Color object. The
   * array is indexed in a 3D manner, with the first dimension representing the
   * width, the second dimension representing the height, and the third dimension
   * representing the depth. The size of the array is determined by the product of
   * the width, height, and depth of the voxel space.
   */
  private Color[] voxels;

  /**
   * Constructor for the VoxelArray class. Initializes the flat array of voxels
   * with the specified width, height, and depth.
   *
   * @param width  The width of the voxel space, representing the number of voxels
   *               along the x-axis.
   * @param height the height of the voxel space, representing the number of
   *               voxels along the y-axis.
   * @param depth  The depth of the voxel space, representing the number of voxels
   *               along the z-axis.
   */
  VoxelArray(int width, int height, int depth) {
    voxels = new Color[width * height * depth];
  }

  int getIndex(int x, int y, int z, int width, int height) {
    return x + y * width + z * width * height;
  }

  void setVoxel(int x, int y, int z, int width, int height, Color color) {
    voxels[getIndex(x, y, z, width, height)] = color;
  }

}
