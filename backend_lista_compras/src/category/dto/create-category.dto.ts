import { IsString, IsOptional } from 'class-validator';

export class CreateCategoryDto {
  @IsString()
  nombre: string;

  @IsOptional()
  @IsString()
  descripcion?: string;
}