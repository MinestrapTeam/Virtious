package minestrapteam.virtious.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class VirtiousFluids extends Fluid
{

	public VirtiousFluids(String fluidName) 
	{
		super(fluidName);
		FluidRegistry.registerFluid(this);
	}

}
