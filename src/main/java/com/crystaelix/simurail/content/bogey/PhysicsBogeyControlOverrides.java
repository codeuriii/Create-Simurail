package com.crystaelix.simurail.content.bogey;

import net.minecraft.nbt.CompoundTag;

public class PhysicsBogeyControlOverrides {

	public boolean overrideBrakeStrength;
	public boolean overrideSteerValue;
	public boolean overrideStressMultiplier;
	private double brakeStrength;
	private double steerValue;
	private double stressMultiplier;

	public boolean hasOverrides() {
		return overrideBrakeStrength || overrideSteerValue || overrideStressMultiplier;
	}

	public void reset() {
		resetBrakeStrength();
		resetSteerValue();
		resetStressMultiplier();
	}

	public double getBrakeStrength() {
		return brakeStrength;
	}

	public void setBrakeStrength(double brakeStrength) {
		this.brakeStrength = Math.clamp(brakeStrength, 0, 1);
		overrideBrakeStrength = true;
	}

	public void resetBrakeStrength() {
		brakeStrength = 0;
		overrideBrakeStrength = false;
	}

	public double getSteerValue() {
		return steerValue;
	}

	public void setSteerValue(double steerValue) {
		this.steerValue = Math.clamp(steerValue, -1, 1);
		overrideSteerValue = true;
	}

	public void resetSteerValue() {
		steerValue = 0;
		overrideSteerValue = false;
	}

	public double getStressMultiplier() {
		return stressMultiplier;
	}

	public void setStressMultiplier(double stressMultiplier) {
		this.stressMultiplier = Math.clamp(stressMultiplier, 0, 1);
		overrideStressMultiplier = true;
	}

	public void resetStressMultiplier() {
		stressMultiplier = 1;
		overrideStressMultiplier = false;
	}

	protected CompoundTag write() {
		CompoundTag tag = new CompoundTag();
		if(overrideBrakeStrength) {
			tag.putDouble("brake_strength", brakeStrength);
		}
		if(overrideSteerValue) {
			tag.putDouble("steer_value", steerValue);
		}
		if(overrideStressMultiplier) {
			tag.putDouble("stress_multiplier", stressMultiplier);
		}
		return tag;
	}

	protected void read(CompoundTag tag) {
		reset();
		if(tag.contains("brake_strength")) {
			overrideBrakeStrength = true;
			brakeStrength = tag.getDouble("brake_strength");
		}
		if(tag.contains("steer_value")) {
			overrideSteerValue = true;
			steerValue = tag.getDouble("steer_value");
		}
		if(tag.contains("stress_multiplier")) {
			overrideStressMultiplier = true;
			stressMultiplier = tag.getDouble("stress_multiplier");
		}
	}
}
