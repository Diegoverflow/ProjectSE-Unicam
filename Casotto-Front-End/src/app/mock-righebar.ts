import { ArticoloBar } from "./articolo";
import { RigaCatalogoBar } from "./riga-catalogo-bar";

export const RIGHEBAR: RigaCatalogoBar[] = [

    new RigaCatalogoBar (new ArticoloBar('coca-cola', 'bevanda analcolica'), 1.5, 20),
    new RigaCatalogoBar (new ArticoloBar('sprite', 'bevanda analcolica'), 1.5, 20),
    new RigaCatalogoBar (new ArticoloBar('fanta', 'bevanda analcolica'), 1.5, 20)

]