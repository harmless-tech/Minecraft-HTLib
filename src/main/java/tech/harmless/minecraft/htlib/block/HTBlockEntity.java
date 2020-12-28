package tech.harmless.minecraft.htlib.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import org.atteo.classindex.IndexSubclasses;

@IndexSubclasses
public class HTBlockEntity extends BlockEntity {
    public HTBlockEntity(BlockEntityType<?> type) {
        super(type);
    }
}
