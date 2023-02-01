// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private PWMSparkMax Left, Right;
    private DifferentialDrive drive;
  
    public DriveSubsystem() {
    
    Left = new PWMSparkMax(Constants.OperatorConstants.Left);
    Right = new PWMSparkMax(Constants.OperatorConstants.Right);

    drive = new DifferentialDrive(Left, Right);
    
    drive.setSafetyEnabled(false);    

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Pilot(double speed, double Rotation){
    drive.arcadeDrive(speed, Rotation);
  }

  public void autoDrive(double speed, double Rotation){
    
    autoDrive(speed, Rotation);
  
  }

  public void stop(){
    drive.stopMotor();
  }


}
