package teamm.mods.virtious.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNative extends ModelBase {
	// fields
	ModelRenderer LegRightBottom;
	ModelRenderer LegLeftBottom;
	ModelRenderer LegRightTop;
	ModelRenderer LegLeftTop;
	ModelRenderer Body;
	ModelRenderer ArmRight;
	ModelRenderer ArmLeft;
	ModelRenderer ArmLeftClawLeft;
	ModelRenderer ArmLeftClawRight;
	ModelRenderer ArmRightClawLeft;
	ModelRenderer ArmRightClawRight;
	ModelRenderer Neck;
	ModelRenderer Jaw;
	ModelRenderer Head;
	ModelRenderer TailBase;
	ModelRenderer TailCenter;
	ModelRenderer TailEnd;

	public ModelNative() {
		textureWidth = 64;
		textureHeight = 32;

		LegRightBottom = new ModelRenderer(this, 28, 0);
		LegRightBottom.addBox(0F, 0F, 0F, 1, 12, 1);
		LegRightBottom.setRotationPoint(-4F, 13F, -3F);
		LegRightBottom.setTextureSize(64, 32);
		LegRightBottom.mirror = true;
		setRotation(LegRightBottom, 0.2792527F, 0F, 0F);
		LegLeftBottom = new ModelRenderer(this, 28, 0);
		LegLeftBottom.addBox(0F, 0F, 0F, 1, 12, 1);
		LegLeftBottom.setRotationPoint(3F, 13F, -3F);
		LegLeftBottom.setTextureSize(64, 32);
		LegLeftBottom.mirror = true;
		setRotation(LegLeftBottom, 0.2792527F, 0F, 0F);
		LegRightTop = new ModelRenderer(this, 20, 0);
		LegRightTop.addBox(0F, 0F, 0F, 2, 10, 2);
		LegRightTop.setRotationPoint(-4.5F, 4F, -1F);
		LegRightTop.setTextureSize(64, 32);
		LegRightTop.mirror = true;
		setRotation(LegRightTop, -0.2792527F, 0F, 0F);
		LegLeftTop = new ModelRenderer(this, 20, 0);
		LegLeftTop.addBox(0F, 0F, 0F, 2, 10, 2);
		LegLeftTop.setRotationPoint(2.5F, 4F, -1F);
		LegLeftTop.setTextureSize(64, 32);
		LegLeftTop.mirror = true;
		setRotation(LegLeftTop, -0.2792527F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 6, 8, 4);
		Body.setRotationPoint(-3F, -2F, -3F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0.1745329F, 0F, 0F);
		ArmRight = new ModelRenderer(this, 32, 0);
		ArmRight.addBox(0F, 0F, 0F, 2, 6, 2);
		ArmRight.setRotationPoint(-4F, 0F, 0F);
		ArmRight.setTextureSize(64, 32);
		ArmRight.mirror = true;
		setRotation(ArmRight, -1.658063F, 0F, 0F);
		ArmLeft = new ModelRenderer(this, 32, 0);
		ArmLeft.addBox(0F, 0F, 0F, 2, 6, 2);
		ArmLeft.setRotationPoint(2F, 0F, 0F);
		ArmLeft.setTextureSize(64, 32);
		ArmLeft.mirror = true;
		setRotation(ArmLeft, -1.658063F, 0F, 0F);
		ArmLeftClawLeft = new ModelRenderer(this, 40, 0);
		ArmLeftClawLeft.addBox(0F, 0F, 0F, 1, 2, 1);
		ArmLeftClawLeft.setRotationPoint(-4.5F, 0F, -6F);
		ArmLeftClawLeft.setTextureSize(64, 32);
		ArmLeftClawLeft.mirror = true;
		setRotation(ArmLeftClawLeft, -0.5410521F, 0F, 0F);
		ArmLeftClawRight = new ModelRenderer(this, 40, 0);
		ArmLeftClawRight.addBox(0F, 0F, 0F, 1, 2, 1);
		ArmLeftClawRight.setRotationPoint(-3F, 0F, -6F);
		ArmLeftClawRight.setTextureSize(64, 32);
		ArmLeftClawRight.mirror = true;
		setRotation(ArmLeftClawRight, -0.5410521F, 0F, 0F);
		ArmRightClawLeft = new ModelRenderer(this, 40, 0);
		ArmRightClawLeft.addBox(0F, 0F, 0F, 1, 2, 1);
		ArmRightClawLeft.setRotationPoint(2F, 0F, -6F);
		ArmRightClawLeft.setTextureSize(64, 32);
		ArmRightClawLeft.mirror = true;
		setRotation(ArmRightClawLeft, -0.5410521F, 0F, 0F);
		ArmRightClawRight = new ModelRenderer(this, 40, 0);
		ArmRightClawRight.addBox(0F, 0F, 0F, 1, 2, 1);
		ArmRightClawRight.setRotationPoint(3.5F, 0F, -6F);
		ArmRightClawRight.setTextureSize(64, 32);
		ArmRightClawRight.mirror = true;
		setRotation(ArmRightClawRight, -0.5410521F, 0F, 0F);
		Neck = new ModelRenderer(this, 44, 0);
		Neck.addBox(0F, 0F, 0F, 2, 3, 2);
		Neck.setRotationPoint(-1F, -3F, -4F);
		Neck.setTextureSize(64, 32);
		Neck.mirror = true;
		setRotation(Neck, 0.4712389F, 0F, 0F);
		Jaw = new ModelRenderer(this, 16, 13);
		Jaw.addBox(0F, 0F, 0F, 6, 1, 6);
		Jaw.setRotationPoint(-3F, -3F, -7F);
		Jaw.setTextureSize(64, 32);
		Jaw.mirror = true;
		setRotation(Jaw, 0.1745329F, 0F, 0F);
		Head = new ModelRenderer(this, 16, 20);
		Head.addBox(0F, 0F, 0F, 5, 3, 5);
		Head.setRotationPoint(-2.5F, -6F, -6.5F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0.1745329F, 0F, 0F);
		TailBase = new ModelRenderer(this, 0, 12);
		TailBase.addBox(0F, 0F, 0F, 3, 3, 5);
		TailBase.setRotationPoint(-1.5F, 3F, 1F);
		TailBase.setTextureSize(64, 32);
		TailBase.mirror = true;
		setRotation(TailBase, -0.4886922F, 0F, 0F);
		TailCenter = new ModelRenderer(this, 0, 20);
		TailCenter.addBox(0F, 0F, 0F, 2, 2, 5);
		TailCenter.setRotationPoint(-1F, 5.5F, 4F);
		TailCenter.setTextureSize(64, 32);
		TailCenter.mirror = true;
		setRotation(TailCenter, -0.2792527F, 0F, 0F);
		TailEnd = new ModelRenderer(this, 0, 27);
		TailEnd.addBox(0F, 0F, 0F, 1, 1, 4);
		TailEnd.setRotationPoint(-0.5F, 7F, 8F);
		TailEnd.setTextureSize(64, 32);
		TailEnd.mirror = true;
		setRotation(TailEnd, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		LegRightBottom.render(f5);
		LegLeftBottom.render(f5);
		LegRightTop.render(f5);
		LegLeftTop.render(f5);
		Body.render(f5);
		ArmRight.render(f5);
		ArmLeft.render(f5);
		ArmLeftClawLeft.render(f5);
		ArmLeftClawRight.render(f5);
		ArmRightClawLeft.render(f5);
		ArmRightClawRight.render(f5);
		Neck.render(f5);
		Jaw.render(f5);
		Head.render(f5);
		TailBase.render(f5);
		TailCenter.render(f5);
		TailEnd.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
//		LegLeftTop.rotateAngleX = -0.2792527F + MathHelper.cos(f * 0.3332F) * 1.2F * f1;
//		LegRightTop.rotateAngleX = -0.2792527F + MathHelper.cos(f * 0.3332F + 3.141593F) * f1;
//		LegLeftBottom.rotateAngleX = 0.2792527F + LegLeftTop.rotateAngleX;
//		LegRightBottom.rotateAngleX = 0.2792527F + LegRightTop.rotateAngleX;
		
//		TailBase.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
//		TailCenter.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1 + TailBase.rotateAngleY;
//		TailEnd.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1 + TailCenter.rotateAngleY;
	}
}
