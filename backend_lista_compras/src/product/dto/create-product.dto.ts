import { IsString, IsNumber } from 'class-validator';

export class CreateProductDto {
  @IsString()
  nombre: string;

  @IsNumber()
  cantidad: number;

  @IsNumber()
  precio: number;

  @IsString()
  categoriaId: string;
}
