package teamm.mods.virtious.model;

import teamm.mods.virtious.entity.EntityBurfalaunt;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.MathHelper;

public class ModelBurfalaunt extends ModelBase {
	// fields
	ModelRenderer Mane;
	ModelRenderer Body;
	ModelRenderer BackRightLeg;
	ModelRenderer FrontRightLeg;
	ModelRenderer FrontLeftLeg;
	ModelRenderer BackLeftLeg;
	ModelRenderer Head;
	ModelRenderer NoseBottom;
	ModelRenderer NoseTop;
	ModelRenderer RightHornBottom;
	ModelRenderer LeftHornBottom;
	ModelRenderer RightHornTop;
	ModelRenderer LeftHornTop;
	ModelRenderer TailBase;
	ModelRenderer Tail;
	private float headRotation;

	public ModelBurfalaunt() {
		textureWidth = 128;
		textureHeight = 64;

		Mane = new ModelRenderer(this, 0, 24);
		Mane.addBox(0F, 0F, 0F, 14, 14, 8);
		Mane.setRotationPoint(-7F, 3F, -9F);
		Mane.setTextureSize(128, 64);
		Mane.mirror = true;
		setRotation(Mane, -0.0698132F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-6F, 3F, -1F, 12, 12, 12);
		Body.setRotationPoint(0F, 2F, 0F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, -0.0698132F, 0F, 0F);
		BackRightLeg = new ModelRenderer(this, 48, 0);
		BackRightLeg.addBox(0F, 0F, 0F, 5, 14, 5);
		BackRightLeg.setRotationPoint(-7F, 10F, 4F);
		BackRightLeg.setTextureSize(128, 64);
		BackRightLeg.mirror = true;
		setRotation(BackRightLeg, 0F, 0F, 0F);
		FrontRightLeg = new ModelRenderer(this, 48, 0);
		FrontRightLeg.addBox(0F, 0F, 0F, 5, 14, 5);
		FrontRightLeg.setRotationPoint(-6F, 10F, -8F);
		FrontRightLeg.setTextureSize(128, 64);
		FrontRightLeg.mirror = true;
		setRotation(FrontRightLeg, 0F, 0F, 0F);
		FrontLeftLeg = new ModelRenderer(this, 48, 0);
		FrontLeftLeg.addBox(0F, 0F, 0F, 5, 14, 5);
		FrontLeftLeg.setRotationPoint(1F, 10F, -8F);
		FrontLeftLeg.setTextureSize(128, 64);
		FrontLeftLeg.mirror = true;
		setRotation(FrontLeftLeg, 0F, 0F, 0F);
		BackLeftLeg = new ModelRenderer(this, 48, 0);
		BackLeftLeg.addBox(0F, 0F, 0F, 5, 14, 5);
		BackLeftLeg.setRotationPoint(2F, 10F, 4F);
		BackLeftLeg.setTextureSize(128, 64);
		BackLeftLeg.mirror = true;
		setRotation(BackLeftLeg, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 16, 46);
		Head.addBox(-4F, -4F, -7F, 8, 8, 8);
		Head.setRotationPoint(0F, 10F, -7F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		NoseBottom = new ModelRenderer(this, 48, 32);
		NoseBottom.addBox(-2F, 1F, -8F, 4, 1, 1);
		NoseBottom.setRotationPoint(0F, 10F, -7F);
		NoseBottom.setTextureSize(128, 64);
		NoseBottom.mirror = true;
		setRotation(NoseBottom, 0F, 0F, 0F);
		NoseTop = new ModelRenderer(this, 50, 30);
		NoseTop.addBox(0F, 0F, 0F, 2, 1, 1);
		NoseTop.setRotationPoint(-1F, 10F, -15F);
		NoseTop.setTextureSize(128, 64);
		NoseTop.mirror = true;
		setRotation(NoseTop, 0F, 0F, 0F);
		RightHornBottom = new ModelRenderer(this, 68, 0);
		RightHornBottom.addBox(0F, 0F, 0F, 4, 1, 1);
		RightHornBottom.setRotationPoint(-6F, 6F, -12F);
		RightHornBottom.setTextureSize(128, 64);
		RightHornBottom.mirror = true;
		setRotation(RightHornBottom, 0F, 0F, 0.5585054F);
		LeftHornBottom = new ModelRenderer(this, 68, 0);
		LeftHornBottom.addBox(0F, -1F, 0F, 4, 1, 1);
		LeftHornBottom.setRotationPoint(6F, 6F, -12F);
		LeftHornBottom.setTextureSize(128, 64);
		LeftHornBottom.mirror = true;
		setRotation(LeftHornBottom, 0F, 0F, 2.583087F);
		RightHornTop = new ModelRenderer(this, 68, 2);
		RightHornTop.addBox(0F, 0F, 0F, 3, 1, 1);
		RightHornTop.setRotationPoint(-6F, 6F, -12F);
		RightHornTop.setTextureSize(128, 64);
		RightHornTop.mirror = true;
		setRotation(RightHornTop, 0F, 0F, -1.012291F);
		LeftHornTop = new ModelRenderer(this, 68, 2);
		LeftHornTop.addBox(0F, -1F, 0F, 3, 1, 1);
		LeftHornTop.setRotationPoint(6F, 6F, -12F);
		LeftHornTop.setTextureSize(128, 64);
		LeftHornTop.mirror = true;
		setRotation(LeftHornTop, 0F, 0F, -2.164208F);
		TailBase = new ModelRenderer(this, 0, 46);
		TailBase.addBox(0F, 0F, 0F, 4, 4, 4);
		TailBase.setRotationPoint(-2F, 8F, 9F);
		TailBase.setTextureSize(128, 64);
		TailBase.mirror = true;
		setRotation(TailBase, 0F, 0F, 0F);
		Tail = new ModelRenderer(this, 0, 54);
		Tail.addBox(0F, 0F, 0F, 2, 2, 2);
		Tail.setRotationPoint(-1F, 8F, 12F);
		Tail.setTextureSize(128, 64);
		Tail.mirror = true;
		setRotation(Tail, 0.2268928F, 0F, 0F);
		
//		Head.addChild(NoseTop);
//		Head.addChild(NoseBottom);
//		LeftHornBottom.addChild(LeftHornTop);
//
//		Head.addChild(LeftHornBottom);
//		RightHornBottom.addChild(RightHornTop);
//		Head.addChild(RightHornBottom);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Mane.render(f5);
		Body.render(f5);
		BackRightLeg.render(f5);
		FrontRightLeg.render(f5);
		FrontLeftLeg.render(f5);
		BackLeftLeg.render(f5);
		Head.render(f5);
		NoseBottom.render(f5);
		NoseTop.render(f5);
		RightHornBottom.render(f5);
		LeftHornBottom.render(f5);
		RightHornTop.render(f5);
		LeftHornTop.render(f5);
		TailBase.render(f5);
		Tail.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	/**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
//    public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4)
//    {
//        super.setLivingAnimations(entity, par2, par3, par4);
//        float yRot = 6.0F + ((EntityBurfalaunt)entity).func_70894_j(par4) * 9.0F;
//        this.Head.rotationPointY = yRot;
//        this.NoseBottom.rotationPointY = yRot;
//        this.NoseTop.rotateAngleX = yRot;
//        this.LeftHornBottom.rotateAngleX = yRot;
////        this.LeftHornTop.rotateAngleX = yRot;
//        this.RightHornBottom.rotateAngleX = yRot;
////        this.RightHornTop.rotateAngleX = yRot;
//        this.headRotation = ((EntityBurfalaunt)entity).func_70890_k(par4);
//    }
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BackLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
		BackRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * f1;
		FrontLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * f1;
		FrontRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
		
//        this.Head.rotateAngleX = this.headRotation;
//        this.NoseBottom.rotateAngleX = this.headRotation;
//        this.NoseTop.rotateAngleX = this.headRotation;
//        this.LeftHornBottom.rotateAngleX = this.headRotation;
////        this.LeftHornTop.rotateAngleX = this.headRotation;
//        this.RightHornBottom.rotateAngleX = this.headRotation;
////        this.RightHornTop.rotateAngleX = this.headRotation;

	}

}
