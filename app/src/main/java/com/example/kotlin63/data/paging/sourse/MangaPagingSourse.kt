package com.example.kotlin63.data.paging.sourse

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin63.data.remote.apiservises.AnimeMangaApiServises
import com.example.kotlin63.data.remote.models.mangamodels.Data
import retrofit2.HttpException
import java.io.IOException

class MangaPagingSource(private val mangaApi: AnimeMangaApiServises) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val pageSize = params.loadSize
        val position = params.key ?: 1
        return try {
            val response = mangaApi.getManga(limit = pageSize, offset = position)
            val nextPage = if (response.data.isNotEmpty()) position + 1 else null

            LoadResult.Page(
                data = response.data, prevKey = null, nextKey = nextPage
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}
