package com.globant.openbankmarvel.repositories

import com.globant.domain.model.*
import com.globant.domain.repositories.SearchRepository

class FakeSearchRepository : SearchRepository {

        private val thumbnail: Thumbnail = Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784","jpg")
        private val urlList1: UrlData = UrlData("Details", "www.google.com")
        private val urlList2: UrlData = UrlData("Details2", "www.google.com")
        private val urlList: List<UrlData> = listOf(urlList1, urlList2)
        private val heroData: HeroData = HeroData("1", "Marvel", thumbnail, urlList)
        private val dataObject : DataObject = DataObject(listOf(heroData))



    override suspend fun getHerosList(pk: String, ts: String, hash: String): DataObject {
        return dataObject;
    }
}