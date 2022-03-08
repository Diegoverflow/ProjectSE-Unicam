import { CategoriaOmbrellone } from "../categoria-ombrellone"
import { Ombrellone } from "./ombrellone"
import { RigaCatalogoOmbrellone } from "./riga-catalogo-ombrellone"

export const RIGHEOMBRELLONI: RigaCatalogoOmbrellone[] = [
    
    new RigaCatalogoOmbrellone(new Ombrellone( CategoriaOmbrellone.PREMIUM, "123"), 3),
    new RigaCatalogoOmbrellone(new Ombrellone( CategoriaOmbrellone.VIP, "1234"), 2),
    new RigaCatalogoOmbrellone(new Ombrellone(CategoriaOmbrellone.STANDARD, "12345"), 1)

]