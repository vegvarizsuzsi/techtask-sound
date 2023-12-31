// automatically generated by the FlatBuffers compiler, do not modify

package com.codecool.techtask.Contract;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class ModifySound extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static ModifySound getRootAsModifySound(ByteBuffer _bb) { return getRootAsModifySound(_bb, new ModifySound()); }
  public static ModifySound getRootAsModifySound(ByteBuffer _bb, ModifySound obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public ModifySound __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int id() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String name() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  public String extension() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer extensionAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer extensionInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }
  public byte data(int j) { int o = __offset(10); return o != 0 ? bb.get(__vector(o) + j * 1) : 0; }
  public int dataLength() { int o = __offset(10); return o != 0 ? __vector_len(o) : 0; }
  public ByteVector dataVector() { return dataVector(new ByteVector()); }
  public ByteVector dataVector(ByteVector obj) { int o = __offset(10); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer dataAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public ByteBuffer dataInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 10, 1); }

  public static int createModifySound(FlatBufferBuilder builder,
      int id,
      int nameOffset,
      int extensionOffset,
      int dataOffset) {
    builder.startTable(4);
    ModifySound.addData(builder, dataOffset);
    ModifySound.addExtension(builder, extensionOffset);
    ModifySound.addName(builder, nameOffset);
    ModifySound.addId(builder, id);
    return ModifySound.endModifySound(builder);
  }

  public static void startModifySound(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addId(FlatBufferBuilder builder, int id) { builder.addInt(0, id, 0); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(1, nameOffset, 0); }
  public static void addExtension(FlatBufferBuilder builder, int extensionOffset) { builder.addOffset(2, extensionOffset, 0); }
  public static void addData(FlatBufferBuilder builder, int dataOffset) { builder.addOffset(3, dataOffset, 0); }
  public static int createDataVector(FlatBufferBuilder builder, byte[] data) { return builder.createByteVector(data); }
  public static int createDataVector(FlatBufferBuilder builder, ByteBuffer data) { return builder.createByteVector(data); }
  public static void startDataVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endModifySound(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public ModifySound get(int j) { return get(new ModifySound(), j); }
    public ModifySound get(ModifySound obj, int j) {  return obj.__assign(Table.__indirect(__element(j), bb), bb); }
  }
}

