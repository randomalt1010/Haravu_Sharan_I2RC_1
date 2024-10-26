// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class tankDrive extends Command {
  Drivetrain dt;
  Joystick joystick;
  /** Creates a new tankDrive. */
  public tankDrive(Drivetrain dt, Joystick joystick) {
    this.dt = dt;
    this.joystick = joystick;
    addRequirements(dt);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.tankDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPowerRaw = joystick.getRawAxis(1);
    double rightPowerRaw = joystick.getRawAxis(5);
    dt.tankDrive(leftPowerRaw, rightPowerRaw);
    SmartDashboard.putNumber("left power", leftPowerRaw);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
