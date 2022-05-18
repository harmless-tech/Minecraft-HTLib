package tech.harmless.minecraft.htlib.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.atteo.classindex.IndexSubclasses;

@IndexSubclasses
public class HTBlockEntity extends BlockEntity {
    public HTBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
