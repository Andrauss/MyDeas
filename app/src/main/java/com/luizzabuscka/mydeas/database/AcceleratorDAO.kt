package com.luizzabuscka.mydeas.database

import com.luizzabuscka.mydeas.model.Accelerator

/**
 * Created by luizzabuscka on 15/09/17.
 */
class AcceleratorDAO {

  fun select(): List<Accelerator> {
    return listOf<Accelerator>(
        Accelerator("ACE Startups", "https://goace.vc/", "11 3251-1372", -23.5703375, -46.646167),
        Accelerator("Fumsoft", "http://www.fumsoft.org.br/empreendedorismo/acelera-mg",
            "31 3194-7650", -19.9452917, -43.9227083),
        Accelerator("Acelera Partners", "http://acelerapartners.com/", "11 3232-4563", -23.608004,
            -46.6967348),
        Accelerator("Baita", "http://www.baita.ac/", "11 3232-4563", -22.8390902, -47.0522043),
        Accelerator("C.E.S.A.R Labs", "http://www.cesarlabs.com/", "81 3419-6700", -8.0597897,
            -34.8719014),
        Accelerator("Outsource Brazil", "http://outsourcebrazil.com.br/", "21 2266-3130",
            -22.9559085, -43.1871459),
        Accelerator("Start You Up", "http://www.startyouup.com.br/", "27 3019-7996", -20.2767328,
            -40.3001743),
        Accelerator("Techmall", "http://techmallsa.com.br/", "31 2510-1418", -19.913546,
            -43.9252039),
        Accelerator("Ventiur", "http://ventiur.net/", "51 3012-5020", -29.7924362, -51.1557218),
        Accelerator("Wow", "http://www.wow.ac/", "51 3018-7647", -30.025737, -51.2122868)
    )
  }

}