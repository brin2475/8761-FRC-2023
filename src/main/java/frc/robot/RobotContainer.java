// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Autos;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ArmSubsystem Arm = new ArmSubsystem();

  private final DriveSubsystem DriveTrain = new DriveSubsystem();
  
  private static final Joystick Brian = new Joystick(Constants.OperatorConstants.Brians_stick);
    
  private static final Joystick Will = new Joystick(Constants.OperatorConstants.Ritters_stick);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    DriveTrain.setDefaultCommand(
      new RunCommand(
        () -> DriveTrain.Pilot(Brian.getX(), Brian.getY()), DriveTrain
      )
    );

    

    
    
    
    // Configure the trigger bindings
    configureBindings();

  }

  
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    
   JoystickButton lowerSolenoidButton = new JoystickButton(Will, 5);
    JoystickButton upperSolenoidButton = new JoystickButton(Will, 3);

    
  

   lowerSolenoidButton.onTrue(
      new StartEndCommand(() -> Arm.LowerSolenoidControl(true), 
      () -> Arm.LowerSolenoidControl(false), 
      Arm)
    );

    upperSolenoidButton.onTrue(
      new StartEndCommand(() -> Arm.upperSolenoidControl(true), 
      () -> Arm.upperSolenoidControl(false), 
      Arm)
    );

}

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
