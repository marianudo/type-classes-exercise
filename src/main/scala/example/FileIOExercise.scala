package example

import java.io.File

import cats.Id
import cats.data.State

object FileIOExercise {
  abstract class FileIO[F[_]] {
    // -------------------------
    // PRIMITIVE OPERATIONS FOR THIS ALGEBRA
    // -------------------------
    // Returns None of the file does not exist
    def read(file: File): F[Option[Array[Byte]]]
    def write(file: File)(content: Array[Byte]): F[Unit]

    // Returns true if the delete operation took effect
    // Returns false for example if we pass a not existent file
    def delete(file: File): F[Boolean]

    // -------------------------
    // DERIVED OPERATIONS
    // To be implemented in terms of primitive operations or other derived operations
    // -------------------------
    def copy(origin: File, destination: File): F[Unit] = ???
    def move(origin: File, destination: File): F[Unit] = ???
    def touch(file: File): F[Unit] = ???
  }

  object FileIO {
    // -------------------------
    // Syntax for the FileIO type class
    // -------------------------
    // TODO Add syntax here
  }

  object FileIOProgram {
    // TODO Implement using the FileIO syntax
    // A function that, given a File:
    // - reads it.
    // - Converts it to String, using UTF-8 as encoding
    // - Adds the given String as a new line
    // - Copy it to the current user home directory
    // - Move the original copy to the given new location
    // - Returns the content of that moved file
    def fileIOFunctionF[F[_]: FileIO](originFile: File, lineToAdd: String, newFileLocaltion: File): F[Option[Array[Byte]]] = ???
  }

  // TODO Implement the following interpreters
  object SynchronousFileSystemInterpreter extends FileIO[Id] {
    override def read(file: File): Id[Option[Array[Byte]]] = ???

    override def write(file: File)(content: Array[Byte]): Id[Unit] = ???

    override def delete(file: File): Id[Boolean] = ???
  }

  sealed abstract class IOOp
  case class Read(file: File) extends IOOp
  // Complete ADT, one type per FileIO primitive operation

  type FileIOState[A] = State[IOOp, A]

  object StateBasedInterpreter extends FileIO[FileIOState] {
    override def read(file: File): FileIOState[Option[Array[Byte]]] = ???

    override def write(file: File)(content: Array[Byte]): FileIOState[Unit] = ???

    override def delete(file: File): FileIOState[Boolean] = ???
  }
}
