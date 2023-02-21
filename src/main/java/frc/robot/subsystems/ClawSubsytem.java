// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ClawSubsystem extends SubsystemBase {
  private Solenoid Claw;
 /** Creates a new ClawSubsystem. */
  public ClawSubsystem() {

    Claw = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.OperatorConstants.Claw);
    Compressor comp = new Compressor(0, PneumaticsModuleType.CTREPCM);
      comp.enableDigital();
 }
  public void LowerSolenoidControl(Boolean retractORextend){
    if(retractORextend == true){
      lowerSolenoid.set(true);
    }
    else{
      lowerSolenoid.set(false);
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
