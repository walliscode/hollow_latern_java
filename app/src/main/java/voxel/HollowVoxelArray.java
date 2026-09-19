package voxel;

import javafx.scene.paint.Color;

public class HollowVoxelArray {

  enum HollowStrategy {

    basicHollow
  }

  /**
   * [TODO:description]
   */
  private HollowStrategy hollowStragegy = HollowStrategy.basicHollow;

  private final Color[] inputVoxels;

  private Color[] outputVoxels;

  HollowVoxelArray(Color[] input_voxels) {
    this.inputVoxels = input_voxels;
  }

  HollowVoxelArray(Color[] inputVoxels, HollowStrategy hollowStragegy) {
    this.inputVoxels = inputVoxels;
    this.hollowStragegy = hollowStragegy;
  }

  void setHollowStragegy(HollowStrategy hollowStragegy) {
    this.hollowStragegy = hollowStragegy;
  }

  void runHollow() {

  }

  void runBasicHollow() {

  }
}
